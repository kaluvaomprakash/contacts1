package com.agilecrm.service;

import java.util.ArrayList;

import com.agilecrm.model.contact_dto;

public interface contactservice {

	
	public int addContactservice(contact_dto contact);
	public int updateContact(contact_dto contact);
	public int delectContact(int id);
	public contact_dto getContactById(int id);
	 public ArrayList<contact_dto> getAllEmployees();
	
	
	
}
