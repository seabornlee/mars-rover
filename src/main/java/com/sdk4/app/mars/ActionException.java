package com.sdk4.app.mars;

public class ActionException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private Rover rover;
	
	public ActionException(Rover rover, String errorMessage) {
		super(errorMessage);
		
		this.rover = rover;
	}

	public Rover getRover() {
		return rover;
	}

}
