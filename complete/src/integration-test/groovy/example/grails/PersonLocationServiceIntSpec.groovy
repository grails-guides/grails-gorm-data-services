// tag::PersonLocationServiceIntSpecBegin[]
package example.grails

import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class PersonLocationServiceIntSpec extends Specification  {

    PersonLocationService personLocationService

    void "test search persons by state"() {
        when:
        List<Person> persons = personLocationService.searchByState("TX")

        then:
        persons.size() == 2
        persons.find { it.name == "Nirav"}
        persons.find { it.name == "Jeff"}

        when:
        List<Person> single = personLocationService.searchByState("Spain")

        then:
        single.size() == 1
        single.find { it.name == "Sergio"}
    }
// end::PersonLocationServiceIntSpecBegin[]

    // tag::testAvgPersonInAState[]
    void "test avg age for persons in a state"() {
        when:
        BigDecimal avgAge = personLocationService.getAverageAgeOfPersonsInState("TX")

        then:
        avgAge == 44.5
    }
    // end::testAvgPersonInAState[]
}
