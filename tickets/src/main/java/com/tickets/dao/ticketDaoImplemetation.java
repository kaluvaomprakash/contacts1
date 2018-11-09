package com.tickets.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tickets.model.ticketsDto;
import com.tickets.util.jdbcConnections;

public class ticketDaoImplemetation implements ticketDao {

	
	//done
	public int addTicket(ticketsDto ticket) {
		int status=0;
		
		try {
			Connection con=jdbcConnections.getConnection();
			PreparedStatement ps =con.prepareStatement("insert into ticket(ticketid,name,email,problemType,problemDescription,status) values(?,?,?,?,?,?)");
			
			ps.setInt(1,ticket.getTicketId());
			ps.setString(2, ticket.getName());
			ps.setString(3, ticket.getEmail());
			ps.setString(4, ticket.getProblemType());
			ps.setString(5, ticket.getProblemDescription());
			ps.setString(6, ticket.getStatus());
			status=ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	//done
	public ticketsDto getTicketById(int id) {
			
		ticketsDto tdto=new ticketsDto();
		
		try {
			 Connection	con = (Connection) jdbcConnections.getConnection();
			 PreparedStatement ps =con.prepareStatement("select * from ticket where ticketid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				tdto.setTicketId(rs.getInt(1));
				tdto.setName(rs.getString(2));
				tdto.setEmail(rs.getString(3));
				tdto.setProblemType(rs.getString(4));
				tdto.setProblemDescription(rs.getString(5));
				tdto.setStatus(rs.getString(6));
				}
		}
		
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return tdto;
	}
	//done
	public int deleteTicket(int id) {
		int status=0;
		try {
			Connection con =  jdbcConnections.getConnection();
			PreparedStatement ps =(con).prepareStatement("delete from ticket where ticketid=?");
			ps.setInt(1, id);
			status =ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	//done
	public int updateTicket(ticketsDto ticket) {
		ticketsDto tdto =new ticketsDto();
		int status=0;
		try {		
			Connection con =jdbcConnections.getConnection();
			PreparedStatement ps =con.prepareStatement("update ticket set status=? where ticketid=?");
			ps.setString(1, ticket.getStatus());
			ps.setInt(2, ticket.getTicketId());
			status=ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public ArrayList<ticketsDto> getAllTickets() {

		ArrayList<ticketsDto> list = new ArrayList();
		
		try {		
			Connection con =jdbcConnections.getConnection();
			PreparedStatement ps =con.prepareStatement("select * from ticket");
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				ticketsDto tdto = new ticketsDto();
				tdto.setTicketId(rs.getInt(1));
				tdto.setName(rs.getString(2));
				tdto.setEmail(rs.getString(3));
				tdto.setProblemType(rs.getString(4));
				tdto.setProblemDescription(rs.getString(5));
				tdto.setStatus(rs.getString(6));
				list.add(tdto);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
