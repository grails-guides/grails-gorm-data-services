package example.grails

import grails.util.Environment
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

@CompileStatic
@Slf4j
class BootStrap {

    PersonDataService personDataService

    def init = { servletContext ->
        if(Environment.current == Environment.DEVELOPMENT) {
            [
                    [name: 'Nirav', age: 39, addresses: [
                            [streetName: "101 Main St", city: "Grapevine", state: "TX", country: "USA"],
                            [streetName: "2929 Pearl St", city: "Austin", state: "TX", country: "USA"],
                            [streetName: "21 Sewickly Hills Dr", city: "Sewickley", state: "PA", country: "USA"]]],
                    [name: 'Jeff', age: 50, addresses: [
                            [streetName: "888 Olive St", city: "St Louis", state: "MO", country: "USA"],
                            [streetName: "1515 MLK Blvd", city: "Austin", state: "TX", country: "USA"]]],
                    [name: 'Sergio', age: 35, addresses: [
                            [streetName: "9291 Calle de Futbal", city: "Madrid", state: 'Castilla-La Mancha', country: "Spain"]]]
            ].each { Map<String, Object> m ->
                personDataService.saveWithListOfAddressesMap(m.name as String,
                        m.age as Integer,
                        m.addresses as List<Map<String, Object>>)
            }
        }
    }

    def destroy = {
    }
}
