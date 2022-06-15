package mvc.demo

import grails.gorm.services.Service

@Service(Person)
interface PersonRepository {

    Person save(Person person)

    Person findById(Long id)

}