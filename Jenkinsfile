
pipeline{
    agent any

    triggers{
        pollSCM('')
    }
    tools{
        maven 'M3'
        jdk 'JDK17'
    }
    //test
    environment{
        APP_NAME = 'crtris-backend'
        DOCKER_IMAGE = 'crtris-backend'
    }

    stages{
        stage("Checkout"){
            steps{
                git branch: 'master',
                    url: 'https://github.com/m1xerxd/crtris-.git'
            }
        }

        stage("Build and Test"){
            steps{
                bat 'mvn clean compile -DskipTests'

                bat 'mvn package -DskipTests'
            }
        }

        stage("Build docker image"){
            steps{
                bat "docker build -t ${DOCKER_IMAGE}:latest ."

                bat "docker images"
            }
        }

        stage("Deploy"){
            steps{
                script{
                    bat 'docker compose down || true'
                    bat 'docker compose up -d'
                }
            }
        }
    }
}