def call(name){
  echo "Hey $name. How are you...!"

  node {
     checkout scm
     stage ("Compile") {
	sh "gcc Hello.c -o Example"
     }
     stage ("Run") {
	sh "./Example"
     }

  }
}
