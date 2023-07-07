pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
               git branch: 'main', url: 'https://github.com/sivaram2662/container-micro-frontned.git'
                sh "aws ecr get-login-password --region ap-south-1 | sudo docker login --username AWS --password-stdin 315073111691.dkr.ecr.ap-south-1.amazonaws.com"
               sh "sudo docker build -t dumy ."
               sh "sudo docker tag dumy:latest 315073111691.dkr.ecr.ap-south-1.amazonaws.com/dumy:$BUILD_NUMBER"
               sh "sudo docker push 315073111691.dkr.ecr.ap-south-1.amazonaws.com/dumy:$BUILD_NUMBER"

            }

        }
    }
}
