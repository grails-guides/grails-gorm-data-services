package example.grails

import grails.gorm.services.Query
import grails.gorm.services.Service

@Service(Person)
abstract class PersonLocationService {
    @Query(""" // <1>
    select distinct ${person}
    from ${Person person} join ${person.addresses} a // <2>
    where a.state = $state
    """)
    protected abstract List<Person> searchByState(String state) // <3>

    BigDecimal getAverageAgeOfPersonsInState(String state) { // <4>
        List<Person> persons = searchByState("TX") // <5>
        List<Integer> ages = persons.collect { it.age }
        ages.sum() / ages.size()
    }
}
