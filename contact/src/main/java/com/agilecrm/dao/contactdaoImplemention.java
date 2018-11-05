package com.agilecrm.dao;

import java.awt.List;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.agilecrm.dto.contact_dto;

import com.agilecrm.util.jdbcConnections;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class contactdaoImplemention implements contactsDAO {

	

	public int addContact(contact_dto contact) {
		int status=0;
		try {
			Connection con=(Connection) jdbcConnections.getConnection();
			 PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into contact(id,firstName,lastName,email,createdBy,createdDate,address,dob,isActive,updatedBy,updatedDate) values(?,?,?,?)");
			ps.setString(1,contact.getId());
			ps.setString(2, contact.getFirstName());
			ps.setString(3, contact.getLastName());
			ps.setString(4, contact.getEmail());
			ps.setString(5, contact.getCreatedBy());
			ps.setDate(6, (Date) contact.getCreatedDate());
			ps.setString(7, contact.getAddress());
			ps.setDate(8, (Date) contact.getDob());
									
			
			status=ps.executeUpdate();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	public int  updateContact(contact_dto contact) {
		int status=0;
		try {
			Connection con =(Connection) jdbcConnections.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("update contact custId=?,firstName=?,lastName=?,mobileNo=? where id=?");
			ps.setString(1,contact.getCustId());
			ps.setString(2, contact.getFirstName());
			ps.setString(3, contact.getLastName());
			ps.setLong(4, contact.getMobileNo());
			
			status=ps.executeUpdate();
		con.close();	
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	public int delectContact(String id) {
		int status=0;
		try {
			Connection con = (Connection)jdbcConnections.getConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from contact where id=?");
			ps.setString(1, id);
			status=ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	
	
	public contact_dto getContactById(String id) {
	
		contact_dto cdto=new contact_dto();
	
		try {
			Connection con = (Connection) jdbcConnections.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from contact where id=?");
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cdto.setCustId(rs.getString(1));
				cdto.setFirstName(rs.getString(2));
				cdto.setLastName(rs.getString(3));
				cdto.setMobileNo(rs.getLong(4));
			}
			con.close();		
			
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cdto;
	}
	public ArrayList<contact_dto> getAllEmployees() {
		
		ArrayList<contact_dto> al = new ArrayList<contact_dto>();
		
		try {
			Connection con =(Connection) jdbcConnections.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from contact ");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				contact_dto cdto=new contact_dto();
				cdto.setCustId(rs.getString(1));  
                cdto.setFirstName(rs.getString(2));  
                cdto.setLastName(rs.getString(3));  
               cdto.setMobileNo(rs.getLong(4));
               al.addAll(al);  
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return al;
	}

	

	

}
