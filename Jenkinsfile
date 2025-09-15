#!/usr/bin/env groovy

@SuppressWarnings('NoSandbox')
properties([
    parameters([]),
    pipelineTriggers([]),
    disableConcurrentBuilds()
])
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
                git branch: 'Docker_Jenk',
                    url: 'https://github.com/m1xerxd/crtris-.git'
            }
        }

        stage("Build and Test"){
            steps{
                sh 'mvn clean package'
            }
        }

        stage("Build docker image"){
            steps{
                sh "docker build -t ${DOCKER_IMAGE}:latest ."

                sh "docker images | grep ${DOCKER_IMAGE}"
            }
        }

        stage("Deploy"){
            steps{
                script{
                    sh 'docker compose down || true'
                    sh 'docker compose up -d'
                }
            }
        }
    }
}