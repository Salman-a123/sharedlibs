def call(name){
  echo "Hey $name. How are you...!"

  node {
     checkout scm
     stage ("Compile") {
	sh "gcc hello.c -o hello"
     }
     stage ("Run") {
	sh "./hello"
     }

  }
}
