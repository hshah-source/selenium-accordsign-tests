pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'jdk11'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: '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', url: 'https://github.com/yourusername/yourrepo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Report') {
            steps {
                echo 'Generating reports...'
            }
        }
    }

    post {
        always {
            echo 'Cleaning workspace...'
            cleanWs()
        }
    }
}
