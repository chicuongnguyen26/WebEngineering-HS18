package mvc

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class HomeSpec extends GebSpec {

    // Defines a when-then workflow
    void "Home access with secured access"() {
        when: "go to openly accessible start page"
        go '/home'
        then: "security intercepts and leads us to login"
        title == "Login"

        when:
        $("form").username = "guest"
        $("form").password = "guest"
        $("input", type: "submit").click()

        then: "successful login leads to requested page"
        title == ""
        $("output").text() == "Hello 'guest'!"
    }
}
