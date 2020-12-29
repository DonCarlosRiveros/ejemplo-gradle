pipeline
{
    agent any
    parameters
    {
        choice(name: 'opciones', choices: ['maven','gradle'], description: 'COVID-19 : Opciones disponibles para construcción de la aplicación')
    }
<<<<<<< HEAD
=======
    environment
    {
        NOMBRE_ARCHIVO_GROOVY = ''
        EXITO = ''
        FALLO = ''
    }
>>>>>>> eb6631ca5b2766e0688ad905bb56432f5e814139
    stages
    {
        stage('UnicoPaso')
        {
            steps
            {
                script
                {
                    println 'Se ha seleccionado ' + params.opciones + ' para la construcción de la herramienta'
<<<<<<< HEAD
                    def archivo_groovy = "${params.opciones}" + '.groovy'
                    def tarea = load "${archivo_groovy}"
                    tarea.llamada()
                }
            }
=======
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
            slackSend color: "good", message: "[Carlos M. Riveros C.] [${env.JOB_NAME}] [${params.opciones}] - Ejecución exitosa"
        }
        failure
        {
            slackSend color: "danger", message: "[Carlos M. Riveros C.] [${env.JOB_NAME}] [${params.opciones}] - Ejecución fallida en stage ${env.STAGE_NAME}"            
>>>>>>> eb6631ca5b2766e0688ad905bb56432f5e814139
        }
    }
}
