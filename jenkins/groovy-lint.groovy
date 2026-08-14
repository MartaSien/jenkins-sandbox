/* Minimal Groovy linter, requires Docker Pipeline plugin. */
pipeline {
    agent any
    parameters {
        booleanParam(name: 'VERBOSE', defaultValue: false, description: 'Show verbose linting output')
    }
    stages {
        stage('Groovy Lint') {
            steps {
                script {
                    docker.image('nvuillam/npm-groovy-lint:v18.0.0').inside {
                        sh "npm-groovy-lint jenkins/**/*.groovy --failon error ${params.VERBOSE ? '--verbose' : ''}"
                    }
                }
            }
        }
    }
}