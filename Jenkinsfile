pipeline {
    agent any

    stages {
        stage ('GetProject') {
            steps {
                git branch:'main', url: 'https://github.com/JohncallStack/johnspetitions.git'
            }
        }
        stage ('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage ('Test') {
                    steps {
                        sh 'mvn test'
                    }
                }

        stage ('Repackage') {
                     steps {
                         sh 'mvn spring-boot:repackage'
                     }
                }

        stage('Run') {
                    steps {
                        sh 'java -jar target/*.jar'
                    }
                }

    }
    post {
        success {
            archiveArtifacts allowEmptyArchive: true,
                artifacts: '**/*.war'
        }
        failure {
                    echo 'Build failed. Check logs for details.'
                }
    }
}