"""
Minimal Groovy linter, requires Docker Pipeline plugin.
"""
properties([
    parameters([
        booleanParam(name: 'VERBOSE', defaultValue: false, description: 'Show verbose linting output')
    ])
])

node {
    checkout scm

    stage('Groovy Lint') {
        agent any

        steps {
            docker.image('nvuillam/npm-groovy-lint:v18.0.0').inside {
                sh "npm-groovy-lint jenkins/**/*.groovy --failon error ${params.VERBOSE ? '--verbose' : ''}"
            }
        }
    }
}