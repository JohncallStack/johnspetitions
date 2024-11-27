pipeline {
    agent any

// Downloads the project from github repo.
    stages {
        stage ('GetProject') {
            steps {
                git branch:'main', url: 'https://github.com/JohncallStack/johnspetitions.git'
            }
        }
// Cleans the project by removing compiled files and other generated artifacts.
        stage ('Build') {
            steps {
                sh 'mvn clean:clean'
            }
        }
// Tests as per any unit tests in the test folder.
        stage ('Test') {
                    steps {
                        sh 'mvn test'
                    }
                }
// Compiles and packages app into a WAR file as per the setting set out in the pom.xml
        stage ('Package') {
                    steps {
                        sh 'mvn package'
                    }
                }
// Archives the generated war file.
        stage ('Archive'){
                    steps {
                        archiveArtifacts allowEmptyArchive: true,
                        artifacts: '**/johnspetitions*.war'
                    }
                }
// A step so user has to manually approve the deployment.
        stage('Approve Deployment') {
                    steps {
                        input "The file is ready to deploy. Are you sure you want to proceed?"
                    }
                }
//Deploys to docker container, and runs the container.
        stage ('Deploy'){
            steps {
                 sh 'docker build -f Dockerfile -t myapp .'
                 sh 'docker rm -f "myappcontainer" || true'
                 sh 'docker run --name "myappcontainer" -p 9090:8080 --detach myapp:latest'
                    }
            // post message to confirm success/failure
            post {
                    success {
                        echo 'Deployment successful!'
                    }
                    failure {
                        echo 'Deployment failed'
                    }
                 }
            }
        }
    }