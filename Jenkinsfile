pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'jdk-17'
    }

    stages {
        stage('Checkout') {
            steps {

                checkout scm
            }
        }

        stage('Build') {
            steps {

                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {

                sh 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {

                sh 'mvn jacoco:report'
                jacoco execPattern: '**/target/jacoco.exec'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
    }
}