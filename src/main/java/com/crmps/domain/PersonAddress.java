package com.crmps.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entity_address")
public class PersonAddress implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Person person;
	private Address address;
	private String type;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "person_uid")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	
	public String getType() {
		return type;
	}

	@Id
    @ManyToOne
    @JoinColumn(name = "address_uid")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
