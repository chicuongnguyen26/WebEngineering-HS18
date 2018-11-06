package mvc

import grails.rest.Resource

@Resource(superClass = NonDeleteRestfulController)
class Person {

    String firstName
    String lastName
    String email
    static hasMany = [bookings: Booking]

    String toString() {
        return firstName + " " + lastName
    }

    static constraints = {
        firstName(blank: false, nullable: false)
        lastName(blank: false, nullable: false)
        email nullable: false, email: true
    }
}
