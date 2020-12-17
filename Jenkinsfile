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
        EXITO =""
        FALLO = ""
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
            step
            {
                EXITO = "[{$BUILD_USER}] [${env.JOB_NAME}] [params.opciones] - Ejecución exitosa"
                slackSend color: "good", message: $EXITO
            }
        }
        failure
        {
            step
            {
                FALLO = "[{$BUILD_USER}] [${env.JOB_NAME}] [params.opciones] - Ejecución fallida en stage ${NOMBRE_STAGE}"
                slackSend color: "danger", message: $FALLO
            }
        }
    }
}
