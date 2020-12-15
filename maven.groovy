def call()
{
    stage('Compile')
    {
        sh './mvnw clean compile -e'   
    }
    stage('Test')
    {
        sh './mvnw clean test -e'   
    }
    stage('Jar')
    {
        sh './mvnw clean package -e'
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
    stage('Nexus')
    {
        nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: "build/DevOpsUsach2020-0.0.1.jar"]], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]] 
    }
}
return this;
