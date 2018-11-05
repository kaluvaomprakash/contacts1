package com.agilecrm.dao;

import java.util.ArrayList;

import com.agilecrm.dto.contact_dto;

public interface contactsDAO {

	public int addContact(contact_dto contact);
	public int updateContact(contact_dto contact);
	public int delectContact(String id);
	public contact_dto getContactById(String id);
	 public ArrayList<contact_dto> getAllEmployees();
	
	
}

