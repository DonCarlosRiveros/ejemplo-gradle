def llamada()
{
    stage('Compile')
    {
        sh 'mvn clean compile -e'   
    }
    stage('Test')
    {
        sh 'mvn clean test -e'   
    }
    stage('Jar')
    {
        sh 'mvn clean package -e'
    }
    stage('Sonar')
    {
<<<<<<< HEAD
        def sonarhome = tool('sonar')
=======
        def sonarhome = tool 'sonar'
>>>>>>> eb6631ca5b2766e0688ad905bb56432f5e814139
            withSonarQubeEnv('sonar')
            {
                sh "${sonarhome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
            }
    }
    stage('Nexus')
    {
        nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: "build/DevOpsUsach2020-0.0.1.jar"]], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]] 
    }
}
return this;
