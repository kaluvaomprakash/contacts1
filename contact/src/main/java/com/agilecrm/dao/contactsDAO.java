package com.agilecrm.dao;

import java.util.ArrayList;

import com.agilecrm.model.contact_dto;

public interface contactsDAO {

	public int addContact(contact_dto contact);
	public int updateContact(contact_dto contact);
	public int delectContact(int id);
	public contact_dto getContactById(int id);
	 public ArrayList<contact_dto> getAllEmployees();
	
	
}

