package br.com.jlgregorio.crud.controller;

import br.com.jlgregorio.crud.model.Person;
import br.com.jlgregorio.crud.service.PersonService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "This service manipulates the Person resource", tags = {"person, api, service,"})
@RestController
@RequestMapping("/person/v1")
public class PersonController {

    @Autowired
    private PersonService service;

    @ApiOperation(value = "Get all registered people.")
    @GetMapping(produces = {"application/json", "application/xml"})
    public List<Person> findAll(){
       return service.findAll();
    }

    @ApiOperation(value = "Find a person by id.", response = Person.class)
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public Person findById(@ApiParam(name = "id", value = "An integer value", required = true)
                               @PathVariable("id") long id) throws Exception{
        return service.findById(id);
    }

    @ApiOperation(value = "Store a newly Person", consumes = "application/json, application/xml", produces = "application/json, application/xml")
    @PostMapping(consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public Person save(@ApiParam(name = "person", value = "A person model", type = "Person") @RequestBody Person person ){
        return service.save(person);
    }

    @PutMapping(consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public Person update(@RequestBody Person person) throws Exception{
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) throws Exception{
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
