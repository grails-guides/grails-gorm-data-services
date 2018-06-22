package example.grails

class BootStrap {

    def init = { servletContext ->
        initPersons()
    }
    def destroy = {
    }

    static void initPersons() {
        println "******* Begin bootstrap init() ***************"
        List<Map<String, Object>> dataList = [
                [name: 'Nirav', age: 39, addresses: [
                        [streetName: "101 Main St", city: "Grapevine", state: "TX"],
                        [streetName: "2929 Pearl St", city: "Austin", state: "TX"],
                        [streetName: "21 Sewickly Hills Dr", city: "Sewickley", state: "PA"]]],
                [name: 'Jeff', age: 50, addresses: [
                        [streetName: "888 Olive St", city: "St Louis", state: "MO"],
                        [streetName: "1515 MLK Blvd", city: "Austin", state: "TX"]]],
                [name: 'Sergio', age: 35, addresses: [
                        [streetName: "9291 Calle de Futbal", city: "Madrid", state: "Spain"]]]
        ]

        for (data in dataList) {
            Person p = new Person(name: data.name, age: data.age).save(flush: true)
            for (address in data.addresses) {
                Address a = new Address(address)
                a.save(flush: true, failOnError: true)
                p.addToAddresses(a)
            }
        }
        println "******* End bootstrap init() ***************"
    }

}
