package com.agilecrm.dao;

import com.agilecrm.dto.contact_dto;

public interface contactsDAO {

	public void addContact(contact_dto contact);
	public contact_dto getContact(String id);
	public String delectContact(String id);
	public contact_dto updateContact(String id);
	
}

