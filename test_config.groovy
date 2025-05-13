pipeline {
    agent any
    stages {
        stage('Change config') {
            steps {
                config = readFile "config.cfg"
                echo ${config}
                newconfig = config.replaceAll("PLACEHOLDER_VALUE", "new_value")
                writeFile file: "config.cfg", text: newconfig
                updated_config = readFile "config.cfg"
                echo ${updated_config}
            }
        }
    }
}
