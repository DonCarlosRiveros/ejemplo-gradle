def call()
{
	stage('Build')
	{
		sh 'gradle clean build'
	}
	stage('Sonar')
	{
		def sonarhome = tool 'sonar'
		{
			withSonarQubeEnv('sonar')
			{
				sh "${sonarhome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
			}
		}
	}
	stage('Run')
	{
		sh "nohup gradle bootRun &"
	}
	stage('Rest')
	{
	    sh "curl -X GET http://localhost:8082/rest/mscovid/test?msg=testing"
	}
	stage('Nexus')
	{
		nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'build/libs/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
	}
}
return this;
