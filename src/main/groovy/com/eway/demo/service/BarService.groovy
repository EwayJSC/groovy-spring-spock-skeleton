package com.eway.demo.service

import com.eway.demo.model.Person;
import org.springframework.stereotype.Component;

@Component
class BarService {
    Person hello(String name) {
        Person person = new Person("Tu", 18);
        println 'person to string: ' + person
        println 'hello hashcode: ' + person.hashCode()

        Person person1 = new Person().setName("1").setAge(1)
        println 'person to string: ' + person1

        return person
    }
}

