package br.com.jlgregorio.crud.repository;

import br.com.jlgregorio.crud.model.PersonV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositoryV2 extends JpaRepository<PersonV2, Long> {

}

