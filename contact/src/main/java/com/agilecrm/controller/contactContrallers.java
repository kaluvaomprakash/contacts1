package com.agilecrm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agilecrm.dao.contactdaoImplemention;
import com.agilecrm.model.contact_dto;
@WebServlet("/ContactControllers")
public class contactContrallers extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

	//	ArrayList al=null;
		//al.addAll(new contactdaoImplemention().getAllEmployees());
		System.out.println(new contactdaoImplemention().getAllEmployees().toString());
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) {
		
		String action = request.getParameter("action");
		//action =insert;
		if(action.equals("insert")) {
			processInsert(request,response);
		}
		
		if(action.equals("getbyid")){
		getById(request,response);
	}
		if(action.equals("updatecontact")) {
		updatecontact(request,response);
		}
	}


	private void processInsert(HttpServletRequest request, HttpServletResponse response)  {
		
		contact_dto contact = new contact_dto();
		
		contact.setFirstName(request.getParameter("firstName"));
		contact.setLastName(request.getParameter("lastName"));
		
		try {
			contact.setDob((new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"))));
			contact.setCreatedDate((new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("createdDate"))));
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		contact.setAddress(request.getParameter("address"));
		contact.setEmail(request.getParameter("email"));
		contact.setCreatedBy(Integer.parseInt(request.getParameter("createdBy")));
		contact.setIsActive(Integer.parseInt(request.getParameter("isActive")));
		contact.setUpdatedBy(Integer.parseInt(request.getParameter("updatedBy")));
		
		new contactdaoImplemention().addContact(contact);
		
	}
	
	private void getById(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		contact_dto contact =new contact_dto();
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(new contactdaoImplemention().getContactById(id).toString());
	}

protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
	contact_dto contact = new contact_dto();
//System.out.println(request.getParameter("id"));
	
	int id=Integer.parseInt(request.getParameter("id"));

	int status=new contactdaoImplemention().delectContact(id);
	try {
		PrintWriter pw = response.getWriter();
		if(status>0) {
			pw.println("CONTACT DELETED " +id);
		}
		else {
			pw.println("not deleted");
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
}
private void updatecontact(HttpServletRequest request, HttpServletResponse response) {
	
	contact_dto contact = new contact_dto();
	
	//int id=Integer.parseInt(request.getParameter("id"));
	contact.setId(Integer.parseInt(request.getParameter("id")));
	contact.setFirstName(request.getParameter("firstName"));
	contact.setLastName(request.getParameter("lastName"));	
	contact.setAddress(request.getParameter("address"));
	contact.setEmail(request.getParameter("email"));
	
	new contactdaoImplemention().updateContact(contact);
	
	
	
	
}


}
