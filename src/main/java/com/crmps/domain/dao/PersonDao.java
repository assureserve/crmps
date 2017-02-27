package com.crmps.domain.dao;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.crmps.domain.Person;

@RepositoryRestResource
public interface PersonDao extends CrudRepository<Person, String>{
	
	List<Person> findByLastName(@Param("lastName") String lastName);
}
