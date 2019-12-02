pipeline {
    agent any
    tools {
        maven "Maven"   
    }
    stages {
        stage('Compile-Build') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
        stage('Deployment to Tomcat'){
            steps{
            withCredentials([usernamePassword(credentialsId: 'tomcatCredentials', passwordVariable: 'password', usernameVariable: 'username'),string(credentialsId: 'TOMCAT_URL', variable: 'tomcat_url')]){
                    sh 'curl ${tomcat_url}/manager/text/undeploy?path=/BMI -u ${username}:${password}'
                    sh 'curl -v -u ${username}:${password} -T target/BMI-0.war ${tomcat_url}/manager/text/deploy?path=/BMI'
                }
            }
        }
        stage('Testing'){
            steps {
                sh 'mvn surefire:test'
            }
        }        
     }
              

}
