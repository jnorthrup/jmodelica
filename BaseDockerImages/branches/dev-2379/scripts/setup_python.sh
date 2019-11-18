#!/bin/bash
# 
#    Copyright (C) 2019 Modelon AB
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

ME="$( basename "${BASH_SOURCE[0]}" )"

. ${DOCKER_SRC_DIR}/settings.sh

if [ "$PYTHON_VERSION" = "3" ]; then
    pip_command=pip3
    BUILD_PKGS_JM_REDHAT="python3-pip python3-devel.x86_64"
    BUILD_PKGS_JM_DEBIAN="python3-pip python3-dev"
    BUILD_PYTHON_PIP_PACKAGES="html5lib==1.0.1 notebook==6.0.1 jupyter==1.0.0 colorama==0.4.1 nbformat==4.4.0 Jinja2==2.10.1 openpyxl==2.6.3 mock==3.0.5 natsort==6.0.0 six==1.12.0 MarkupSafe==1.1.1 lxml==4.4.1 matplotlib==3.1.1 scipy==1.3.1 cython==0.29.13 nose==1.3.7 ipython==7.8.0 ipykernel==5.1.2 jpype1==0.7.0 numpy==1.17.1"
else
    pip_command=pip
    BUILD_PKGS_JM_DEBIAN="python-lucene python-dev python-jpype"
    BUILD_PKGS_JM_REDHAT="python-pip python-devel python-jpype"
    BUILD_PYTHON_PIP_PACKAGES="numpy==1.14.4 html5lib notebook==5.7.8 jupyter colorama nbformat Jinja2 mock natsort six MarkupSafe lxml>=4.0.0 matplotlib==2.0.2 scipy==1.2.2 cython==0.29.13 nose ipython==5.7 ipykernel==4.10.0"
fi


if [ "$LINUX_DISTRIBUTION" = "CENTOS" ]; then
	BUILD_PKGS_JM=$BUILD_PKGS_JM_REDHAT
	pckinstall="yum -y install"
elif [ "$LINUX_DISTRIBUTION" = "REDHAT" ]; then
	BUILD_PKGS_JM=$BUILD_PKGS_JM_REDHAT
	pckinstall="yum -y install"
elif [ "$LINUX_DISTRIBUTION" = "DEBIAN" ]; then 
	BUILD_PKGS_JM=$BUILD_PKGS_JM_DEBIAN
	pckinstall="apt-get -y install"
else 
	echo ERROR: current linux distribution not supported yet
    exit 1
fi

${pckinstall} $BUILD_PKGS_JM


if [ "$PYTHON_VERSION" = "2" ]; then
    if [ "$LINUX_DISTRIBUTION" = "DEBIAN" ]; then
        # to avoid installing gcc 7 as well for ubuntu we do this
        apt-get install -y --no-install-recommends python-pip
        
        if [ ! -z "${PYTHON_ENABLED}" ]; then
            pip install setuptools
        fi
        
        echo "${ME}: Installing extra packages for Ubuntu"
        #Install package lsb separately because it conflicts with the installation above
        apt-get -y install lsb python3-notebook jupyter-core python-ipykernel
        
        echo "Installing extra python packages with pip on Ubuntu"
        if [ ! -z "${PYTHON_ENABLED}" ]; then
            pip install numpy==1.14.4
        fi
    fi
fi


if [ -f /etc/centos-release ] && [ "$(cat /etc/centos-release | tr -dc '0-9.'|cut -d \. -f1)" -eq "6" ];
then
    echo "${ME}: Not installing python packages on CentOS 6"
else
    if [ ! -z "${PYTHON_ENABLED}" ]; then
        echo "${ME}:  Installing python packages..."
        ${pip_command} install $BUILD_PYTHON_PIP_PACKAGES
    fi
fi

if [ ! -z "${PYTHON_ENABLED}" ]; then
    echo "${ME}: Installed python packages:"
    ${pip_command} list 
fi
