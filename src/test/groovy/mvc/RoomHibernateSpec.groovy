package mvc;

import grails.test.hibernate.HibernateSpec;

class RoomHibernateSpec extends HibernateSpec {

    @Override
    List<Class> getDomainClasses() {
        return [Room]
    }

    void "Insert a new person and find it"() {
        // Insert
        when:
        def room = new Room(name: '5.3A17', max: 40)
        then: 'room is valid instance'
        room.validate()
        and:
        room.save()

        // Find by capacity
        when:
        def rooms = Room.findAllByMaxGreaterThan(20)
        then:
        rooms.size() == 1
        rooms[0].max == 40
    }
}