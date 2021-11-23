def call(name){
  echo "Hey $name. How are you...!"
  agent {
    echo "I am into the check point 1"
    docker { image 'node:16-alpine'
    }
  }
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
	    step {
    		echo "I am into the check point 1"
		docker { image 'node:16-alpine'
		    }
	    step {
		echo "I am into the check point 2"
		sh'node --version'
	    }
	  }
	  }

  }
}
