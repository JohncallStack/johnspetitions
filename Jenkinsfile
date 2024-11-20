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
                sh 'mvn clean:clean'
            }
        }
        stage ('Test') {
                    steps {
                        sh 'mvn test'
                    }
                }

        stage ('Package') {
                    steps {
                        sh 'mvn package'
                    }
                }

        stage ('Archive'){
                    steps {
                        archiveArtifacts allowEmptyArchive: true,
                        artifacts: '**/johnspetitions*.war'
                    }
                }

        stage ('Deploy'){
            steps {
                 sh 'docker build -f Dockerfile -t myapp .'
                 sh 'docker rm -f "myappcontainer" || true'
                 sh 'docker run --name "myappcontainer" -p 9090:8080 --detach myapp:latest'
                    }
                }
    }
//     post {
//         success {
//             archiveArtifacts allowEmptyArchive: true,
//                 artifacts: '**/*.war'
//         }
//         failure {
//                     echo 'Build failed. Check logs for details.'
//                 }
//     }
}