package org.akshay.techie.messenger.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errorMessageinfo;
	private int errorCode;
	private String documentation;
	public ErrorMessage(String errorMessage, int errorCode, String documentation) {
		this.errorMessageinfo = errorMessage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}
	public ErrorMessage() {
	}
	public String getErrorMessageinfo() {
		return errorMessageinfo;
	}
	public void setErrorMessageinfo(String errorMessage) {
		this.errorMessageinfo = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	
	

}
