package com.agilecrm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agilecrm.dao.contactdaoImplemention;
import com.agilecrm.dto.contact_dto;

@WebServlet("/saveservlet")
public class saveservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw = response.getWriter();
		
		String cutid=request.getParameter("custId");
		String fName=request.getParameter("custName");
		String lName=request.getParameter("lastName");
		long   contact=Long.parseLong(request.getParameter("contact"));
		
		contact_dto condto=new contact_dto();
		
		condto.setCustId(cutid);
		condto.setFirstName(fName);
		condto.setLastName(lName);
		condto.setMobileNo(contact);
		
		contactdaoImplemention condImp=new contactdaoImplemention();
		int status=condImp.addContact(condto);
		
		if(status>0) {
			pw.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else {
			pw.println("Sorry able to create record");
		}
		
		
		
		
	
	}

}
