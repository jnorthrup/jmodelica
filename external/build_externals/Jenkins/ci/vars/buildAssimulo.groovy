def call(JM_CHECKOUT_PATH, JM_BRANCH, INSTALL_PATH, TARGET, bitness=["32", "64"], build_with_msvs=null, BLAS_HOME_BASE=null, LAPACK_HOME_BASE=null, SUPERLU_HOME_BASE=null, SUNDIALS_HOME_BASE=null,USER_CONFIG=null, extra_bat="", stash=false, archive=true) {
    if (JM_CHECKOUT_PATH != null) {
        checkoutJM(${JM_BRANCH})
    }
    INSTALL_PATH_UNIX=unixpath("${INSTALL_PATH}")
    if (BLAS_HOME_BASE == null) {
        BLAS_HOME_BASE="${INSTALL_PATH_UNIX}/blas_install"
    }

    if (LAPACK_HOME_BASE == null) {
        LAPACK_HOME_BASE="${INSTALL_PATH_UNIX}/lapack_install"
    }

    if (SUPERLU_HOME_BASE == null) {
        SUPERLU_HOME_BASE="${INSTALL_PATH_UNIX}/superlu_install"
    }

    if (SUNDIALS_HOME_BASE == null) {
        SUNDIALS_HOME_BASE="${INSTALL_PATH_UNIX}/sundials_install"
    }
    if (build_with_msvs) {
        msvs_suffix="msvs"
    } else {
        msvs_suffix=""
    }
    for (bit in bitness) {
        stage ("assimulo_${TARGET} ${bit}${msvs_suffix} bit") {
            runMSYSWithEnv("""\
            export JM_HOME="\$(pwd)/JModelica/"
            JENKINS_BUILD_DIR="\$(pwd)/build"
            cd \${JM_HOME}/external/build_externals/build/assimulo
            
            make clean BUILD_DIR=\${JENKINS_BUILD_DIR}/assimulo
            make ${TARGET} USER_CONFIG=${USER_CONFIG} JM_HOME=\${JM_HOME} BUILD_DIR=\${JENKINS_BUILD_DIR}/assimulo WORKSPACE=\${WORKSPACE} INSTALL_DIR_FOLDER=${INSTALL_PATH_UNIX}/assimulo/${TARGET}/Python_${bit}
            """, extra_bat);
            if ("${TARGET}" == "folder") {
                runMSYSWithEnv("""\
                export JM_HOME="\$(pwd)/JModelica/"
                nosetests ${INSTALL_PATH_UNIX}/assimulo/${TARGET}/Python_${bit}/folder/assimulo/tests/*.py
                """, "", false, bit); 
            }
            if (stash || archive) {
                dir("${INSTALL_PATH}/assimulo/${TARGET}") {
                    if (stash) {
                        stash includes: "Python_${bit}/**", name: "Python_${bit}_assimulo_${TARGET}"
                    }
                    if (archive) {
                        archiveArtifacts artifacts: "Python_${bit}/**", fingerprint: false
                    }
                }
            }
        }
    }
}