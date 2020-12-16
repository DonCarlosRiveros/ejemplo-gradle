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
                    /* println "${params.opciones}"
                    println "${params.opciones}" + '.groovy' */
                    def archivo_groovy = "${params.opciones}" + '.groovy'
                    /* println "$archivo_groovy" */
                    def tarea = load ("${archivo_groovy}")
                    def tarea = load ("${params.opciones}" + '.groovy')
                    tarea.call()
                }
            }
        }
    }
}
