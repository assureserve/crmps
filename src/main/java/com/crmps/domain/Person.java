package com.crmps.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "person")

public class Person extends AbstractBaseEntity {

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String LastName;

	@Column(name = "govt_id")
	private String govermentId;

	@Column(name = "pic_url")
	private String pictureURL;

	
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "entity_address_rel", joinColumns = {
			@JoinColumn(name = "entity_uid", referencedColumnName = "uid") }, inverseJoinColumns = {
					@JoinColumn(name = "address_uid", referencedColumnName = "uid") })
	private List<Address> addressList = new ArrayList<Address>();

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}




	public String getGovermentId() {
		return govermentId;
	}

	public void setGovermentId(String govermentId) {
		this.govermentId = govermentId;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

}
