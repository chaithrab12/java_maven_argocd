pipeline {
    agent {
        image 'maven:3.8.7-eclipse-temurin-17'
        args '-v /root/.m2:/root/.m2'
      }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/chaithrab12/java_maven_argocd.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE:$DOCKER_TAG .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: 'docker-hub-credentials', url: '']) {
                    sh 'docker push $DOCKER_IMAGE:$DOCKER_TAG'
                }
            }
        }

        stage('Deploy Container') {
            steps {
                sh 'docker stop my-app || true && docker rm my-app || true'
                sh 'docker run -d --name my-app -p 8080:8080 $DOCKER_IMAGE:$DOCKER_TAG'
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
