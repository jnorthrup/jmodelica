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

ARG DOCKER_LINUX_DIST=centos
ARG DOCKER_DIST_TAG=7.4.1708

FROM $DOCKER_LINUX_DIST:$DOCKER_DIST_TAG
MAINTAINER Modelon

ARG DOCKER_USR_PATH=/tmp/dockerfiles
ENV USR_PATH=${DOCKER_USR_PATH}
ENV DOCKER_SRC_DIR=${USR_PATH}/Docker/build
ARG SRC_DIR=scripts

ARG GCC_INSTALL_TYPE=UBUNTU_DEFAULT
ENV GCC_INSTALLATION_TYPE=${GCC_INSTALL_TYPE}
ARG GCC_VERSION_TO_BUILD=6.3.0
ENV GCC_VERSION=${GCC_VERSION_TO_BUILD}

RUN useradd -ms /bin/bash baseuser && groupadd docker && usermod -aG docker baseuser
# switch user back and forth to create bashrc
USER baseuser
USER root

COPY ${SRC_DIR}/*.sh ${DOCKER_SRC_DIR}/
COPY ${SRC_DIR}/jcc.patch ${DOCKER_SRC_DIR}/
RUN chmod +x ${DOCKER_SRC_DIR}/*.sh

RUN ${DOCKER_SRC_DIR}/setup.sh
RUN ${DOCKER_SRC_DIR}/centos_python_env.sh
RUN rm -rf ${USR_PATH}
RUN rm -rf /*.tgz
USER baseuser