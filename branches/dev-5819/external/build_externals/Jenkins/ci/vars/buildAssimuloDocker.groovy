def call(PLATFORM, TARGET, USER_CONFIG) {
    stage("Assimulo ${TARGET} ${PLATFORM}") {
        
        def ARTIFACT_FILE="${WORKSPACE}/JModelica/artifacts_assimulo"
        def MAKE_ARGS="JM_HOME=${WORKSPACE}/JModelica PATH_TO_MOUNT=${WORKSPACE}/JModelica USER_CONFIG=${USER_CONFIG} ARTIFACT_FILE=${ARTIFACT_FILE}"
        
        dir ('JModelica/external/build_externals/docker/src/components/Assimulo') {
            try{
                sh "make docker_${TARGET} ${MAKE_ARGS}"
                sh "make docker_install_${TARGET} ${MAKE_ARGS}"
                dir("${WORKSPACE}/JModelica") {
                    artifact_list = sh returnStdout: true, script: "cat ${ARTIFACT_FILE}"
                    if (TARGET == "wheel") {
                        // need to remove the trailing **\n from the string and append *.whl
                        artifact_pattern = artifact_list.replace("*", "")
                        artifact_pattern = artifact_pattern.replace("\n", "")
                        artifact_pattern = artifact_pattern + "*.whl"
                        echo "artifact_pattern = ${artifact_pattern}"
                        uploadToArtifactory(artifact_pattern, "externals/assimulo/release/3.1/unix/${PLATFORM}/", false, "true")
                    }
                    archiveArtifacts artifacts: artifact_list, fingerprint: false
                    sh "rm ${ARTIFACT_FILE}"
                }
                sh "make docker_test_${TARGET} ${MAKE_ARGS}"
            } finally {
                sh "make clean_in_docker ${MAKE_ARGS}"
            }
        }
    }
}