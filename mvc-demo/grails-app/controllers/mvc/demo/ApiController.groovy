package mvc.demo

import io.micronaut.http.HttpStatus
import org.springframework.beans.factory.annotation.Autowired

class ApiController {

    @Autowired
    PersonRepository repository

    def show(Long id) {
        Person person = repository.findById(id)

        if(person) {
            respond(person)
        } else {
            return HttpStatus.NOT_FOUND
        }
    }
}
