package com.crmps.domain.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.crmps.domain.Address;


public interface AddressDao extends JpaRepository<Address, String>{

}
