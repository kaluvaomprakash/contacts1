package com.tickets.model;

public class ticketsDto {

	private int ticketId;
	private String name;
	private String email;
	private String problemType;
	private String problemDescription;
	private String status;
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProblemType() {
		return problemType;
	}
	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ticketsDao [ticketId=" + ticketId + ", name=" + name + ", email=" + email + ", problemType="
				+ problemType + ", problemDescription=" + problemDescription + ", status=" + status + "]";
	}
	
	
	
}
