package com.prowings.weather.responsedto.model;

public class CustomException {

	private String message;
	private String root;
	private int statuscode;
	public CustomException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomException(String message, String root, int statuscode) {
		super();
		this.message = message;
		this.root = root;
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	@Override
	public String toString() {
		return "CustomException [message=" + message + ", root=" + root + ", statuscode=" + statuscode + "]";
	}
	
	
}
