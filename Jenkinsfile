pipeline
{
    agent any
    parameters
    {
        choice(name: 'opciones', choices: ['maven','gradle'], description: 'COVID-19 : Opciones disponibles para construcción de la aplicación')
    }
    stages
    {
        stage('UnicoPaso')
        {
            steps
            {
                script
                {
                    println 'Se ha seleccionado ' + params.opciones + ' para la construcción de la herramienta'
                    echo("${params.opciones}")
                    echo (${params.buildtool}.groovy)
                    def tarea = load "${params.buildtool}.groovy"
                    tarea.call()
                }
            }
        }
    }
}
