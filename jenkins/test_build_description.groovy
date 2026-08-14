pipeline {
    agent any
    stages {
        stage('Test build description') {
            steps {
                script {
                    returnValue = sh(returnStdout: true, script: "python3 main.py")
                    currentBuild.description = returnValue.tokenize().last()
                }
            }
        }
    }
}
