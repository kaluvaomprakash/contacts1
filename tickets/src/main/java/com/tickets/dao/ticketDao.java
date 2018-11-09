package com.tickets.dao;

import java.util.ArrayList;

import com.tickets.model.ticketsDto;

public interface ticketDao {

	public int addTicket(ticketsDto ticket);
	public int updateTicket(ticketsDto ticket);
	public ticketsDto getTicketById(int id);
	public int deleteTicket(int id);
	public ArrayList<ticketsDto> getAllTickets();
	
}
