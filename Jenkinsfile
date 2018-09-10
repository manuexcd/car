#!groovy

node {
	environment {
		DOCKER_HOST='tcp://127.0.0.1:4243'
	}
	
	stage 'Clone the project'
    git 'https://github.com/manuexcd/car'

	stage 'Docker image'
	sh 'gradle build buildDocker'
	
	stage 'Docker tag'
	sh 'docker tag car manuexcd/car'
	
	stage 'Docker push'
	withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
		sh 'docker login -u $USER -p $PASS'
	}
	sh 'docker push manuexcd/car'
	sh 'docker rmi car:latest manuexcd/car:latest'
}