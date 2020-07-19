pipeline {
    agent {
        node {
         label 'win_box'
        }
    }
    tools {
        maven 'maven3.6'
        jdk 'java'
    }
    stages {
        stage ('Checkout code from SCM'){
            steps {
                    git branch: 'main', url: 'https://github.com/spring-projects/spring-petclinic.git'

                }

            }
        stage ('Run the simple cmd'){
            steps{
                bat """
                echo "this is step after checkout"
                """
            }
        }
        stage ('Perform code compile using maven'){
            steps{
                bat """
                mvn compile
                """
            }

        }

        stage ('Run test'){
            steps {
                bat """
                mvn test
                """
            }

        }

        stage ('Create Package'){

            steps{

                bat """
                mvn package
                """
            }
        }

    }
}
    

