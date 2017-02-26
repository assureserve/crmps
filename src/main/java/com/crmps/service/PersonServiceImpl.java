package com.crmps.service;




import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crmps.domain.Address;
import com.crmps.domain.Person;
import com.crmps.domain.dao.AddressDao;
import com.crmps.domain.dao.PersonDao;

import java.util.List;

@Component
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;


	@Autowired
	private AddressDao addressDao;

	  
	@Override
	public void savePerson(Person person ) {
		
		personDao.save(person);

	}
	
	@Override
	public void saveAddress(Address address) {
		
		addressDao.save(address);
	}

	@Override
	public List<Person> findAllUsers() {
		return personDao.findAll();
	}
}
