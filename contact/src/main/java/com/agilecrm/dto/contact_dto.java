package com.agilecrm.dto;

public class contact_dto {
	
	private String custId;
	private String firstName;
	private String lastName;
	private long mobileNo;
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "contact_dto [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNo="
				+ mobileNo + "]";
	}
	public contact_dto(String custId, String firstName, String lastName, long mobileNo) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
	}
	
	
	
	
		
	

}
