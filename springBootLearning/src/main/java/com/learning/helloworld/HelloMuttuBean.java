package com.learning.helloworld;

public class HelloMuttuBean {
	
	private String message;

	public HelloMuttuBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HelloMuttuBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloMuttuBean [message=" + message + "]";
	}
	
	

}
