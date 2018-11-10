package mvc

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.userdetails.GrailsUser

class HomeController {

    SpringSecurityService springSecurityService

    @Secured(['ROLE_USER'])
    def index() {
        // respond handles content negotation
        render "Hello '${loggedUsername()}'!"
        // Following needs "home/index.gson" and "compile 'org.grails.plugins:views-json:1.2.8'"
        // [name: loggedUsername()]
    }

    String loggedUsername() {
        if (springSecurityService.principal == null) {
            return null
        }
        if (springSecurityService.principal instanceof String) {
            return springSecurityService.principal
        }
        if (springSecurityService.principal instanceof GrailsUser) {
            return ((GrailsUser) springSecurityService.principal).username
        }
        null
    }

}
