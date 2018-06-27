// tag::PersonDataServiceBegin[]
package example.grails

import grails.gorm.services.Join
import grails.gorm.services.Service

@Service(Person)
interface PersonDataService {
    Person findByName(String name)
// end::PersonDataServiceBegin[]

    // tag::findPersonAge[]
    Integer findPersonAge(String name)
    // end::findPersonAge[]

    // tag::findEagerly[]
    @Join('addresses')
    Person findEagerly(String name)
    // end::findEagerly[]

    // tag::savePerson[]
    Person savePerson(Person person)
    // end::savePerson[]
}
