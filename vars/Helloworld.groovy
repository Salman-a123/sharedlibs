def call(name){
  echo "Hey $name. How are you...!"

  node {
     checkout scm
     stage ("Compile") {
	sh "gcc hello.c -o Example"
     }
     stage ("Run") {
	sh "./Example"
     }
	  stage("Run Docker Image") {
	  echo "I am into the docker running stage"
	  }

  }
}
