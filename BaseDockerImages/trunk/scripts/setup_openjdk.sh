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
. ${DOCKER_SRC_DIR}/settings.sh 

ME="$( basename "${BASH_SOURCE[0]}" )"
echo "${ME}: --------------- INSTALLING OpenJDK ---------------"

if [ "$LINUX_DISTRIBUTION" = "CENTOS" ]; then
    if [ -f /etc/centos-release ] && [ "$(cat /etc/centos-release | tr -dc '0-9.'|cut -d \. -f1)" -eq "6" ]; then
        # for CentOS 6 we install openjdk 8 because 11 is not an option
        echo "${ME}: Identified platform as CentOS 6, installing OpenJDK 8"
        yum -y install java-1.8.0-openjdk-devel
    else
        echo "${ME}: Installing OpenJDK 11"
        yum -y install java-11-openjdk-devel
    fi
elif [ "$LINUX_DISTRIBUTION" = "FEDORA" ]; then
    dnf install java-1.8.0-openjdk-devel -y
elif [ "$LINUX_DISTRIBUTION" = "REDHAT" ]; then
	yum -y install java-1.8.0-openjdk-devel
elif [ "$LINUX_DISTRIBUTION" = "DEBIAN" ]; then
    apt-get -y install openjdk-8-jdk
else 
	echo "${ME}: No set openjdk distribution for current linux distribution, exiting..."
    exit 1
fi
