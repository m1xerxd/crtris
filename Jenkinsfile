pipeline{
    agent any

    tools{
        maven 'M3'
        jdk 'JDK17'
    }

    environment{
        APP_NAME = 'crtris-backend'
        DOCKER_IMAGE = 'crtris-backend'
    }

    stages{
        stage("Checkout"){
            steps{
                git branch: '*',
                    url: 'git@github.com:m1xerxd/crtris-.git'
                    credentialsId: 'github-ssh-credentials'
            }
        }

        stage("Build and Test"){
            steps{
                sh 'mvn clean packages'
            }
        }

        stage("Build docker image"){
            steps{
                script{
                    docker.build("${DOCKER_IMAGE}:latest")
                }
            }
        }

        stage("Deploy"){
            steps{
                script{
                    sh 'docker compose down'
                    sh 'docker compose up -d'
                }
            }
        }
    }
}