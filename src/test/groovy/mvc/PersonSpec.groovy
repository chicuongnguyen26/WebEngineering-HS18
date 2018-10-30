package mvc

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PersonSpec extends Specification implements DomainUnitTest<Person> {

    void "First name can NEITHER be null NOR blank"() {
        when:
        domain.firstName = null
        then:
        !domain.validate(['firstName'])
        domain.errors['firstName'].code == 'nullable'

        when:
        domain.firstName = '  '
        then:
        !domain.validate(['firstName'])
        domain.errors['firstName'].code == 'blank'
    }

    void "Email has to be an email"() {
        when:
        domain.email = 'This is NOT an email'
        then:
        !domain.validate(['email'])
        domain.errors['email'].code == 'email.invalid'

        when:
        domain.email = 'christian.ribeaud@fhnw.ch'
        then:
        domain.validate(['email'])
    }

}
