package com.eway.demo.controller

import com.eway.demo.model.Person
import com.eway.demo.service.BarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = 'application/json')
class BarController {
    @Autowired
    private BarService service

    @GetMapping('/bar/{name}')
    Person helloByName(@PathVariable String name) {
        service.hello(name)
    }
}
