package example.grails

import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class PersonDataServiceIntSpec extends Specification {

    PersonDataService personDataService

    void "test join eager load"() {
        when:
        Person person = personDataService.findEagerly("Nirav")

        then:
        person.name == "Nirav"
        person.age == 39
        person.addresses[0].city == "Grapevine"
        person.addresses[1].city == "Austin"
        person.addresses[2].city == "Sewickley"
    }
}
