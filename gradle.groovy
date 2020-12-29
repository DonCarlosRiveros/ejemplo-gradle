def llamada()
{
	stage('Build')
	{
		sh 'gradle clean build'
	}
	stage('Sonar')
	{
		def sonarhome = tool 'sonar'
			withSonarQubeEnv('sonar')
			{
				sh "${sonarhome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
<<<<<<< HEAD
		}
=======
			}
>>>>>>> eb6631ca5b2766e0688ad905bb56432f5e814139
	}
	stage('Run')
	{
		sh "nohup gradle bootRun &"
	}
	stage('Rest')
	{
<<<<<<< HEAD
		sh "sleep 10"
=======
		sleep 10
>>>>>>> eb6631ca5b2766e0688ad905bb56432f5e814139
		sh "curl -X GET http://localhost:8082/rest/mscovid/test?msg=testing"
	}
	stage('Nexus')
	{
<<<<<<< HEAD
		nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'build/libs/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
=======
		nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'build/libs/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '2.0.1']]]
>>>>>>> eb6631ca5b2766e0688ad905bb56432f5e814139
	}
}
return this;
