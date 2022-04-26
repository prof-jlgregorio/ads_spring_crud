package br.com.jlgregorio.crud.service;

import br.com.jlgregorio.crud.model.Person;
import br.com.jlgregorio.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public Person findById(long id) throws Exception{
        return repository.findById(id).orElseThrow(() -> new Exception("Not Found"));
    }

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person save(Person person){
        return repository.save(person);
    }

    public Person update(Person person) throws Exception{
        Person p = findById(person.getId());
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        p.setProfession(person.getProfession());
        return repository.save(p);
    }

    public void delete(long id) throws Exception{
        Person person = findById(id);
        repository.delete(person);
    }


}
