#!/bin/bash
set -e
# note this is currently for CentOS only
ME="$( basename "${BASH_SOURCE[0]}" )"

if [ -z "${GCC_VERSION}" ]; then
    echo "${ME}: Variable GCC_VERSION is not set, exiting..."
    exit 1
else
    echo "${ME}: GCC_VERSION=${GCC_VERSION}, continuing..."
fi

export BUILD_DIR=gcc-${GCC_VERSION}-build

echo "============================================="
echo "Building gcc ${GCC_VERSION} from source"
echo "============================================="

yum group install -y "Development Tools"
yum install -y make wget gmp-devel mpfr-devel libmpc-devel
wget https://ftp.gnu.org/gnu/gcc/gcc-${GCC_VERSION}/gcc-${GCC_VERSION}.tar.gz
tar xzf gcc-${GCC_VERSION}.tar.gz

mkdir -p ${BUILD_DIR}
cd ${BUILD_DIR}
../gcc-${GCC_VERSION}/configure --enable-languages=c,c++,fortran --disable-multilib
make -j$(nproc) && make install

# in a docker environment this source has to be redone when restarting image

echo 'export PATH=/usr/local/bin:$PATH' >> ~/.bashrc
echo 'export LD_LIBRARY_PATH=/usr/local/lib64:$LD_LIBRARY_PATH' >> ~/.bashrc
echo 'export PATH=/usr/local/bin:$PATH' >> /home/baseuser/.bashrc
echo 'export LD_LIBRARY_PATH=/usr/local/lib64:$LD_LIBRARY_PATH' >> /home/baseuser/.bashrc
source ~/.bashrc

echo "\e[33m" "${ME}: Deleting build directory after gcc..." "\e[0m"
rm -rf ../${BUILD_DIR}
echo "\e[33m" "${ME}: Deleting directory with source code from extracting tar..." "\e[0m"
rm -rf ../gcc-${GCC_VERSION}
echo "\e[33m" "${ME}: Deleting gcc-${GCC_VERSION}.tar.gz..." "\e[0m"
rm -rf ../gcc-${GCC_VERSION}.tar.gz