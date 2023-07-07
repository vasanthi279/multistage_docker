pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
               git branch: 'master', url: 'https://github.com/lvthillo/python-flask-docker.git'
                sh "aws ecr get-login-password --region ap-south-1 | sudo docker login --username AWS --password-stdin 315073111691.dkr.ecr.ap-south-1.amazonaws.com"
               sh "sudo docker build -t dumy:backend ."
               sh "sudo docker tag dumy:backend 315073111691.dkr.ecr.ap-south-1.amazonaws.com/dumy:backend"
               sh "sudo docker push 315073111691.dkr.ecr.ap-south-1.amazonaws.com/dumy:backend"

            }

        }
    }
}
