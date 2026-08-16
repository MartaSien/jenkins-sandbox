pipeline {
    agent {
        docker {
            image 'nvuillam/npm-groovy-lint:v18.0.0'
            args '--entrypoint='          // clears the image ENTRYPOINT so Jenkins' keepalive (cat) works
        }
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Groovy Lint') {
            steps {
                sh "npm-groovy-lint --noserver --failon error jenkins/*.groovy"
            }
        }
    }
}