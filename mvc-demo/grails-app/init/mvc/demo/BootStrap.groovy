package mvc.demo

import org.springframework.beans.factory.annotation.Autowired

class BootStrap {

    @Autowired
    PersonRepository repository

    def init = { servletContext ->

        repository.save(new Person(name: "Zak", age: 34))

    }
    def destroy = {
    }
}
