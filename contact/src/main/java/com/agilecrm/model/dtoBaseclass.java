package com.agilecrm.model;

import java.util.Date;

public class dtoBaseclass {

	private int createdBy;
	private Date  createdDate=new Date();
	private int updatedBy;
	private Date updatedDate;
	private int isActive;
	public int getCreatedBy() {
		return createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	@Override
	public String toString() {
		return "dtoBaseclass [createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", isActive=" + isActive + "]";
	}
	
	
	

	
		
}
