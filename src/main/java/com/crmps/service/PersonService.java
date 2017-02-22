package com.crmps.service;

import com.crmps.domain.Address;
import com.crmps.domain.Person;

public interface PersonService {
	
	public void savePerson(Person person );
	
	public void saveAddress(Address address );
	
}
