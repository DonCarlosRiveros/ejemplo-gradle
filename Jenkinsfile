pipeline
{
	agent any

    stages
    {
    	stage('Pipeline')
    	{
    		steps
    		{
    			script
    			{
    				stage ('build & test')
    				{
    					sh './gradlew clean build'
    				}
    				stage ('SonarScanner')
    				{
    					//def scannerHome = tool 'SonarScanner';
    					withSonarQubeEnv('sonar')
    					{
    						sh "/home/carlos/sonar-scanner-4.5.0.2216/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build "
    					}
    				}
    				stage ('run')
    				{

    				}
    				stage ('test')
    				{

    				}
    				stage ('nexus')
    				{

    				}
				}
            }
        }
    }
 }	