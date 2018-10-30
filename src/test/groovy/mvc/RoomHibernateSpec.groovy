package mvc;

import grails.test.hibernate.HibernateSpec;

class RoomHibernateSpec extends HibernateSpec {

    void "Insert a new person and find it"() {
        // Insert
        setup:
        def room = new Room(name: '5.3A17', max: 40)
        when: 'room is valid instance'
        room.validate()
        then:
        room.save()

        // Find by 'max'
        when:
        def rooms = Room.findAllByMaxGreaterThan(20)
        then:
        rooms.size() == 1
        rooms[0].max == 40
    }
}