#!/bin/sh
# 
#    Copyright (C) 2018 Modelon AB
#
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the Common Public License as published by
#    IBM, version 1.0 of the License.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY. See the Common Public License for more details.
#
#    You should have received a copy of the Common Public License
#    along with this program.  If not, see
#     <http://www.ibm.com/developerworks/library/os-cpl.html/>.

set -e

. ${USR_PATH}/Docker/build/settings.sh

BUILD_PKGS_JM_COMMON="vim sudo cmake swig wget tar patch"
BUILD_PKGS_JM_REDHAT="redhat-lsb ant-junit dos2unix python-pip bc make lucene which subversion java-1.8.0-openjdk-devel python-devel python-jpype zlib-devel boost-devel"
BUILD_PKGS_JM_FEDORA="redhat-lsb ant-junit dos2unix bc make lucene which subversion java-1.8.0-openjdk-devel zlib-devel python-pip python-devel python-jpype boost-devel"
BUILD_PKGS_JM_DEBIAN="dos2unix dc ant python-lucene subversion openjdk-8-jdk python-dev python-jpype zlib1g-dev libboost-dev"

BUILD_PYTHON_PIP_PACKAGES="html5lib jupyter colorama nbformat Jinja2 openpyxl mock natsort six MarkupSafe lxml>=4.0.0 matplotlib==2.0.2 scipy cython nose ipython==5.7 ipykernel==4.10.0"

if [ "$LINUX_DISTRIBUTION" = "CENTOS" ]; then
	BUILD_PKGS_JM=$BUILD_PKGS_JM_REDHAT
	yum -y install epel-release  # for some python packages 
	alias pckinstall="yum -y install"
elif [ "$LINUX_DISTRIBUTION" = "FEDORA" ]; then
	BUILD_PKGS_JM=$BUILD_PKGS_JM_FEDORA
    dnf update --best --allowerasing -y
    dnf install redhat-rpm-config -y
	alias pckinstall="yum -y install"
elif [ "$LINUX_DISTRIBUTION" = "REDHAT" ]; then
	BUILD_PKGS_JM=$BUILD_PKGS_JM_REDHAT
	yum -y install epel-release  # for some python packages 
	alias pckinstall="yum -y install"
elif [ "$LINUX_DISTRIBUTION" = "DEBIAN" ]; then 
	BUILD_PKGS_JM=$BUILD_PKGS_JM_DEBIAN
	apt-get update
    apt-get -y install tzdata #install separately due to issues with backends in docker
	alias pckinstall="apt-get -y install"
else 
	echo ERROR: current linux distribution not supported yet
    exit 1
fi

pckinstall $BUILD_PKGS_JM_COMMON
pckinstall $BUILD_PKGS_JM

if [ "$LINUX_DISTRIBUTION" = "DEBIAN" ]; then
    # to avoid installing gcc 7 as well for ubuntu we do this
	apt-get install -y --no-install-recommends python-pip
    pip install setuptools
fi

# Install GCC, input argument is defined in Dockerfile
echo "--------------- INSTALLING GCC ---------------"
. ${USR_PATH}/Docker/build/setup_gcc.sh ${GCC_INSTALLATION_TYPE}



if [ "$LINUX_DISTRIBUTION" = "CENTOS" ] || [ "$LINUX_DISTRIBUTION" = "FEDORA" ]; then
    echo "Installing extra python packages with pip on CentOS"
    ANT_VERSION=1.9.9
    wget http://archive.apache.org/dist/ant/binaries/apache-ant-$ANT_VERSION-bin.tar.gz
    ANTTMP=anttmp
    mkdir $ANTTMP && cd $ANTTMP && tar -xvf ../apache-ant-$ANT_VERSION-bin.tar.gz && cd ..
    mv $ANTTMP/apache-ant-$ANT_VERSION /opt/ant && rm -rf apache-ant-$ANT_VERSION-bin.tar.gz && rm -rf $ANTTMP
    echo 'export ANT_HOME=/opt/ant/'>/etc/profile.d/antenv.sh
    chmod 0755 /etc/profile.d/antenv.sh
elif [ "$LINUX_DISTRIBUTION" = "DEBIAN" ]; then
    echo "Installing extra packages for Ubuntu"
    #Install package lsb separately because it conflicts with the installation above
    apt-get -y install lsb python3-notebook jupyter-core python-ipykernel
    echo "Installing extra python packages with pip on Ubuntu"
    pip install numpy==1.14.4 
fi


if [ -f /etc/centos-release ] && [ "$(cat /etc/centos-release | tr -dc '0-9.'|cut -d \. -f1)" -eq "6" ];
then
    echo "Not installing python packages on CentOS 6"
else
    pip install $BUILD_PYTHON_PIP_PACKAGES
fi

echo "=== installed python packages ==="
pip list 
