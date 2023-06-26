package com.skyheights.dto;

public class ComplaintDTO {

	private String reply;
	private boolean status;

	public ComplaintDTO() {
	}

	public ComplaintDTO(String reply, boolean status) {
		this.reply = reply;
		this.status = status;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ComplaintDTO [reply=" + reply + ", status=" + status + "]";
	}
	
	
}
