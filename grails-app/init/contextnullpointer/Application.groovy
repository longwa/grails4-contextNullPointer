package contextnullpointer

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

import groovy.transform.CompileStatic
import org.springframework.beans.factory.NoSuchBeanDefinitionException

@CompileStatic
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    @Override
    Closure doWithSpring() {
        { ->
            try {
                // This should throw NoSuchBeanDefinitionException but it throws a NullPointerException
                applicationContext.getBean("noSuchBean")
            }
            catch(NoSuchBeanDefinitionException e) {
                println "Caught no such bean exception: $e"
            }
        }
    }
}
