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

ME="$( basename "${BASH_SOURCE[0]}" )"

. ${DOCKER_SRC_DIR}/settings.sh

BUILD_PKGS_JM_COMMON="vim sudo cmake swig wget tar patch"
# removed ant-junit from REDHAT list
BUILD_PKGS_JM_REDHAT="redhat-lsb dos2unix bc make lucene which subversion zlib-devel boost-devel"
BUILD_PKGS_JM_DEBIAN="dos2unix dc ant subversion zlib1g-dev libboost-dev"



if [ "$LINUX_DISTRIBUTION" = "CENTOS" ]; then
	BUILD_PKGS_JM=$BUILD_PKGS_JM_REDHAT
	yum -y install epel-release  # for some python packages 
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


