pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                sh "mvn clean build"
            }
        }
        stage('Test') { 
            steps {
                sh "mvn test"
            }
        }
        stage('Deploy') { 
            steps {
                sh "mvn install"
            }
        }
    }
}
