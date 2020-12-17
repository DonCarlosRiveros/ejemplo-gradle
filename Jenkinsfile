pipeline
{
    agent any
    parameters
    {
        choice(name: 'opciones', choices: ['maven','gradle'], description: 'COVID-19 : Opciones disponibles para construcción de la aplicación')
    }
    environment
    {
        NOMBRE_STAGE = ""
        NOMBRE_TOOL = ""
        NOMBRE_ARCHIVO_GROOVY = ""
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
                    def mensaje_tool = 'Se ha seleccionado ' + params.opciones + ' para la construcción de la herramienta'
                    def archivo_groovy = "${params.opciones}" + '.groovy'
                    NOMBRE_ARCHIVO_GROOVY = "${params.opciones}" + '.groovy'
                    def tarea = load "${NOMBRE_ARCHIVO_GROOVY}"
                    tarea.llamada()
                }
            }
        }
    }
    post
    {
        success
        {
                def exito = "[$BUILD_USER] [${env.JOB_NAME}]" + [params.opciones] + '- Ejecución exitosa'
                slackSend color: "good", message: $exito
        }
        failure
        {
            def fallo = "[$BUILD_USER] [${env.JOB_NAME}]" + [params.opciones] + '- Ejecución fallida en stage $NOMBRE_STAGE ([)$NOMBRE_TOOL)'
            slackSend color: "danger", message: $fallo
        }
    }
}
