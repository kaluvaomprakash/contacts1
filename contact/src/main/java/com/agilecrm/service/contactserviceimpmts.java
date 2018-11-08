package com.agilecrm.service;

import java.util.ArrayList;

import com.agilecrm.dao.contactdaoImplemention;
import com.agilecrm.model.contact_dto;

public class contactserviceimpmts implements contactservice{

	contactdaoImplemention contdaoimp =new contactdaoImplemention();
	
	public int addContactservice(contact_dto contact) {
		
		return contdaoimp.addContact(contact);
	}

	public int updateContact(contact_dto contact) {
		
		return contdaoimp.updateContact(contact);
	}

	public int delectContact(int id) {
		return contdaoimp.delectContact(id);
	}

	public contact_dto getContactById(int id) {
		return contdaoimp.getContactById(id);
	}

	public ArrayList<contact_dto> getAllEmployees() {
		return contdaoimp.getAllEmployees();
	}

	

}
