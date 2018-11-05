package com.agilecrm.controller;

import java.util.ArrayList;

import com.agilecrm.dao.contactdaoImplemention;
import com.agilecrm.dto.contact_dto;

public class contactserviceimpmts implements contactservice{

	contactdaoImplemention contdaoimp =new contactdaoImplemention();
	
	public int addContact(contact_dto contact) {
		
		return contdaoimp.addContact(contact);
	}

	public int updateContact(contact_dto contact) {
		
		return contdaoimp.updateContact(contact);
	}

	public int delectContact(String id) {
		return contdaoimp.delectContact(id);
	}

	public contact_dto getContactById(String id) {
		return contdaoimp.getContactById(id);
	}

	public ArrayList<contact_dto> getAllEmployees() {
		return contdaoimp.getAllEmployees();
	}

}
