package example.grails

import grails.gorm.services.Join
import grails.gorm.services.Service

@Service(Person)
interface PersonDataService {
    Person findByName(String name)
    Integer findPersonAge(String name)
    @Join('addresses')
    Person findEagerly(String name)
    Person savePerson(Person person)
}
