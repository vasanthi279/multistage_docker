 pipeline{
    agent any
    stages{
        stage('Build-frontend') {
            steps {
                script{
                sh '''
               aws ecr get-login-password --region ap-south-1 | sudo docker login --username AWS --password-stdin 315073111691.dkr.ecr.ap-south-1.amazonaws.com
               sudo docker build -t dumy .
               sudo docker tag dumy:latest 315073111691.dkr.ecr.ap-south-1.amazonaws.com/dumy:latest
               sudo docker push 315073111691.dkr.ecr.ap-south-1.amazonaws.com/dumy:latest
                '''
                }
            }
        }
       
        

    }
}