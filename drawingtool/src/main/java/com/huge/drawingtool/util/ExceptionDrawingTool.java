package com.huge.drawingtool.util;

public class ExceptionDrawingTool extends Exception{
	
	protected String msnTechnical;
	protected String msnUser;
	protected String id;
	protected Exception exceptionSource;
	
	public ExceptionDrawingTool() {	}

	public ExceptionDrawingTool(String message, Exception exceptionSource) {
		super(message);
		this.exceptionSource = exceptionSource;
	}

	public ExceptionDrawingTool(String msnTechnical, String msnUser, String id,
			Exception exceptionSource) {
		super();
		this.msnTechnical = msnTechnical;
		this.msnUser = msnUser;
		this.id = id;
		this.exceptionSource = exceptionSource;
	}

	public String getMsnTechnical() {
		return msnTechnical;
	}

	public void setMsnTechnical(String msnTechnical) {
		this.msnTechnical = msnTechnical;
	}

	public String getMsnUser() {
		return msnUser;
	}

	public void setMsnUser(String msnUser) {
		this.msnUser = msnUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Exception getExceptionSource() {
		return exceptionSource;
	}

	public void setExceptionSource(Exception exceptionSource) {
		this.exceptionSource = exceptionSource;
	}

}
