package com.crmps;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crmps.domain.Address;
import com.crmps.domain.Person;
import com.crmps.domain.dao.PersonDao;
import com.crmps.service.PersonService;


@RunWith(SpringRunner.class)
@SpringBootTest


public class CrmpsApplicationTests {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonDao personDao;

	
	@Test
	public void contextLoads() {
	}
	
	//@Test 
	public void testSavePerson()
	{
		Person person = new Person ();
		person.setEmail("Test");
		person.setPassword("Test");
		person.setFirstName("Test");
		person.setLastName("Test");
		//personService.savePerson(person);
		
	}
	
	
	//@Test 
	public void testSaveAddress()
	{
		Address address = new Address();
		address.setStreet1("setStreet1 ");
		address.setStreet2("setStreet2 ");
		address.setCity( "City");
		address.setState("Stat");
		address.setZip("300013");
		address.setCountry("US");
		address.setType("HOME");
		personService.saveAddress(address);

		
	}
	
	@Test 
	public void testAddressForPerson()
	{
		Person person = new Person ();
		person.setEmail("Test");
		person.setPassword("Test");
		person.setFirstName("Test");
		person.setLastName("Test");
		
		Address address = new Address();
		address.setStreet1("setStreet1 ");
		address.setStreet2("setStreet2 ");
		address.setCity( "City");
		address.setState("Stat");
		address.setZip("300013");
		address.setCountry("US");
		address.setType("HOME");
		
		person.getAddressList().add(address);
		personService.savePerson(person);
		
	}

}
