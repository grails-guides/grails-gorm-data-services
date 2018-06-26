// tag::PersonDataServiceSpec[]
package example.grails

import grails.test.hibernate.HibernateSpec
import spock.lang.Shared

class PersonDataServiceSpec extends HibernateSpec {

    @Shared
    PersonDataService personDataService

    def setup() {
        personDataService = this.hibernateDatastore.getService(PersonDataService)
        BootStrap.initPersons()
    }

    void "test find person by name"() {
        when:
        Person person = personDataService.findByName("Nirav")

        then:
        person.name == "Nirav"
        person.age == 39
    }
// end::PersonDataServiceSpec[]

    // tag::test1[]
    void "test find persons age projection"() {
        when:
        Integer age = personDataService.findPersonAge("Nirav")

        then:
        age == 39
    }
    // end::test1[]

    // tag::test2[]
    void "test save person"() {
        when:
        Person newPerson = new Person(name: "Bob", age: 22)
        Person person = personDataService.savePerson(newPerson)

        then:
        person.name == "Bob"
        person.age == 22
    }
    // end::test2[]

    // tag::test3[]
    void "test save person with address"() {
        when:
        Person newPerson = new Person(name: "Bob", age: 22)
        Address address = new Address(streetName: "500 Berry St", city: "Fort Worth", state: "TX")
        newPerson.addToAddresses(address)
        Person person = personDataService.savePerson(newPerson)

        then:
        person.name == "Bob"
        person.addresses[0].streetName == "500 Berry St"
        person.addresses[0].city == "Fort Worth"
        person.addresses[0].state == "TX"
    }
    // end::test3[]
}
