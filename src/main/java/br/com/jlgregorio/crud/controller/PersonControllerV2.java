package br.com.jlgregorio.crud.controller;

import br.com.jlgregorio.crud.model.Person;
import br.com.jlgregorio.crud.model.PersonV2;
import br.com.jlgregorio.crud.service.PersonService;
import br.com.jlgregorio.crud.service.PersonServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/v2")
public class PersonControllerV2 {

    @Autowired
    private PersonServiceV2 service;

    @GetMapping
    public List<PersonV2> findAll(){
       return service.findAll();
    }

    @GetMapping("/{id}")
    public PersonV2 findById(@PathVariable("id") long id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public PersonV2 save(@RequestBody PersonV2 person){
        return service.save(person);
    }

    @PutMapping
    public PersonV2 update(@RequestBody PersonV2 person) throws Exception{
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) throws Exception{
        service.delete(id);
        return ResponseEntity.ok().build();
    }







}
