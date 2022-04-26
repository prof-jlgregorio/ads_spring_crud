package br.com.jlgregorio.crud.service;

import br.com.jlgregorio.crud.model.Person;
import br.com.jlgregorio.crud.model.PersonV2;
import br.com.jlgregorio.crud.repository.PersonRepository;
import br.com.jlgregorio.crud.repository.PersonRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceV2 {

    @Autowired
    PersonRepositoryV2 repository;

    public PersonV2 findById(long id) throws Exception{
        return repository.findById(id).orElseThrow(() -> new Exception("Not Found"));
    }

    public List<PersonV2> findAll(){
        return repository.findAll();
    }

    public PersonV2 save(PersonV2 personV2){
        return repository.save(personV2);
    }

    public PersonV2 update(PersonV2 personV2) throws Exception{
        PersonV2 p = findById(personV2.getId());
        p.setFirstName(personV2.getFirstName());
        p.setLastName(personV2.getLastName());
        p.setProfession(personV2.getProfession());
        //..this attribute exists only in version V2
        p.setGender(personV2.getGender());
        return repository.save(p);
    }

    public void delete(long id) throws Exception{
        PersonV2 personV2 = findById(id);
        repository.delete(personV2);
    }


}
