def call(name){
  echo "Hey $name. How are you...!"

  node {
     checkout scm
     stage ("Compile") {
	sh "python hello.py"
     }
  }
}
