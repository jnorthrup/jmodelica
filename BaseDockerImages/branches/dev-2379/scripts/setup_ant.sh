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


if [ "$LINUX_DISTRIBUTION" = "CENTOS" ] || [ "$LINUX_DISTRIBUTION" = "FEDORA" ]; then
    ANT_VERSION=1.9.9
    echo "${ME}: Installing ANT version ${ANT_VERSION}"
    wget http://archive.apache.org/dist/ant/binaries/apache-ant-$ANT_VERSION-bin.tar.gz
    ANTTMP=anttmp
    mkdir $ANTTMP && cd $ANTTMP && tar -xvf ../apache-ant-$ANT_VERSION-bin.tar.gz && cd ..
    mv $ANTTMP/apache-ant-$ANT_VERSION /opt/ant && rm -rf apache-ant-$ANT_VERSION-bin.tar.gz && rm -rf $ANTTMP
    echo 'export ANT_HOME=/opt/ant/'>/etc/profile.d/antenv.sh
    chmod 0755 /etc/profile.d/antenv.sh
fi
