package com.tickets.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tickets.dao.ticketDao;
import com.tickets.dao.ticketDaoImplemetation;
import com.tickets.model.ticketsDto;

public class ticketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");

		ObjectMapper mapper = new ObjectMapper();
		PrintWriter out = response.getWriter();
		ticketDao service = new ticketDaoImplemetation();
		List<ticketsDto> list = service.getAllTickets();
		if(list.isEmpty())
			out.write("Sorry! unable to fetch record");
		else {
			mapper.writeValueAsString(list);
			String jsonInString = mapper.writeValueAsString(list);
			out.write(jsonInString);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action =request.getParameter("action");
		
		if(action.equals("insertTicket")) {
			processInsert(request,response);
		}
		
		if(action.equals("updateTicket")) {
			processUpdate(request,response);
		}
		
		if(action.equals("getTicketById"))
			getTicketById(request,response);
		

	}
	private void getTicketById(HttpServletRequest request, HttpServletResponse response) {
		
		ticketsDto tdao = new ticketsDto();
		int id=(Integer.parseInt(request.getParameter("ticketid")));
		System.out.println(new ticketDaoImplemetation().getTicketById(id).toString());		
		
	}

	private void processUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int status=0;
		ticketsDto tdao = new ticketsDto();
		tdao.setTicketId(Integer.parseInt(request.getParameter("ticketid")));
		tdao.setStatus(request.getParameter("status"));
		
		 status=new ticketDaoImplemetation().updateTicket(tdao);
		 PrintWriter pw =response.getWriter();
		 if(status==0) {
			 pw.println("ticket not updated");
		 }
		 else {
			 pw.print("ticket updated");
		 }
		
	}

	protected void doDelete(HttpServletRequest request,HttpServletResponse response) {
		ticketsDto tdao = new ticketsDto();
		int ticketid=Integer.parseInt(request.getParameter("ticketid"));
		System.out.println(ticketid);
		int status=new ticketDaoImplemetation().deleteTicket(ticketid);
		
		try {
			PrintWriter pw = response.getWriter();
			if(status>0) {
				pw.println("TICKET DELETED " +ticketid);
			}
			else {
				pw.println("TICKET not deleted");
			}
		} catch (IOException e) {
			e.printStackTrace();
	}
	}

	private void processInsert(HttpServletRequest request, HttpServletResponse response) {
		
		ticketsDto tdao =new ticketsDto();
		tdao.setName(request.getParameter("name"));
		tdao.setEmail(request.getParameter("email"));
		tdao.setProblemType(request.getParameter("problemType"));
		tdao.setProblemDescription(request.getParameter("problemDescription"));
		tdao.setStatus(request.getParameter("status"));
		
		new ticketDaoImplemetation().addTicket(tdao);
		
		
		
	}

}
