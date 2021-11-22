def call(name){
  echo "Hey $name. How are you...!"

  node {
     checkout scm
     stage ("Compile") {
     sh "python hello.py"
     }
    stage('Back-end') {
      agent {
        docker { image 'maven:3.8.1-adoptopenjdk-11' }
      }
      steps {
        sh 'mvn --version'
      }
    }
    stage('Front-end') {
      agent {
        docker { image 'node:16-alpine' }
      }
      steps {
        sh 'node --version'
      }
    } 
  }
}
