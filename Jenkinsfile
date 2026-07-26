pipeline {
    agent any
    stages {
        stage("environment variables") {
            steps {
                sh 'printenv'
                sh 'ls -la'
            }
        }
        stage('Pull Request Number') {
            when {
                changeRequest target: 'master'
            }
            steps {
                echo "PR: ${CHANGE_ID}"
            }
        }
        stage('Test') {
            steps {
                sh 'python -m pytest'
            }
        }
    }
}