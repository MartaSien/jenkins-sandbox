pipeline {
    agent any
    stages {
        stage('Change config') {
            steps {
                script {
                    def config = readFile "config.cfg"
                    echo "${config}"
                    def newconfig = config.replaceAll("PLACEHOLDER_VALUE", "new_value")
                    writeFile file: "config.cfg", text: newconfig
                    def updated_config = readFile "config.cfg"
                    echo "${updated_config}"
                }
            }
        }
    }
}
