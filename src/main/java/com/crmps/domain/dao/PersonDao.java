package com.crmps.domain.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.crmps.domain.Person;


public interface PersonDao extends JpaRepository<Person, String>{
	

}
