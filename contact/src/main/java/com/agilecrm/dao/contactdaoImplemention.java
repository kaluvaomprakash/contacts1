package com.agilecrm.dao;

import java.util.List;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.agilecrm.model.contact_dto;
import com.agilecrm.util.jdbcConnections;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class contactdaoImplemention implements contactsDAO {

	
//done
	public int addContact(contact_dto contact) {
		int status=0;
		try {
			Connection con=(Connection) jdbcConnections.getConnection();
			 PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into contact(firstName,lastName,createdBy,createdDate,address,dob,isActive,updatedBy,email) values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, contact.getFirstName());
			ps.setString(2, contact.getLastName());
			ps.setInt(3, contact.getCreatedBy());
			ps.setDate(4, new java.sql.Date(contact.getCreatedDate().getTime()));
			ps.setString(5, contact.getAddress());
			ps.setDate(6, new java.sql.Date(contact.getDob().getTime()));
			ps.setInt(7,contact.getIsActive());
			ps.setInt(8, contact.getUpdatedBy());	
			ps.setString(9, contact.getEmail());

			status=ps.executeUpdate();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	//done
	public int  updateContact(contact_dto contact) {
		int status=0;
		try {
			Connection con =(Connection) jdbcConnections.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("update contact set firstName=?,lastName=?,address=?,email=? where id=?");
			ps.setInt(5, contact.getId());
			ps.setString(1, contact.getFirstName());
			ps.setString(2, contact.getLastName());
			ps.setString(3, contact.getAddress());
			ps.setString(4,contact.getEmail());
			
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
	
	//done
	public int delectContact(int id) {
		int status=0;
		try {
			Connection con = (Connection)jdbcConnections.getConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from contact where id=?");
			ps.setInt(1, id);
			status=ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	//almost done
	public contact_dto getContactById(int id) {
	
		contact_dto cdto=new contact_dto();
	
		try {
			Connection con = (Connection) jdbcConnections.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from contact where id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cdto.setId(rs.getInt(1));
				cdto.setFirstName(rs.getString(2));
				cdto.setLastName(rs.getString(3));
				cdto.setCreatedBy(rs.getInt(4));
				cdto.setCreatedDate(rs.getDate(5));
				cdto.setAddress(rs.getString(6));
				cdto.setDob(rs.getDate(7));
				cdto.setIsActive(8);
				cdto.setUpdatedBy(rs.getInt(9));
				cdto.setEmail(rs.getString(10));
			}
				
			
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
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from contact");
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()) {
				contact_dto cdto=new contact_dto();
				//if(rs.next()) {
					cdto.setId(rs.getInt(1));
					cdto.setFirstName(rs.getString(2));
					cdto.setLastName(rs.getString(3));
					cdto.setCreatedBy(rs.getInt(4));
					cdto.setCreatedDate(rs.getDate(5));
					cdto.setAddress(rs.getString(6));
					cdto.setDob(rs.getDate(7));
					cdto.setIsActive(8);
					cdto.setUpdatedBy(rs.getInt(9));
					cdto.setEmail(rs.getString(10));
					al.add(cdto);
				//}
				
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
