package com.babatunde.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ApiResponse {

	public static final String SUCCESS = "00";
	public static final String ALREADYEXISTS = "11";
	public static final String PROCESSORERROR = "22";
	public static final String NOTFOUND = "404";
	public static final String EXCEPTIONOCCURED="500";

	private String code=PROCESSORERROR;
	private String message;
	private String obj = null;
	
	public ApiResponse(String message) {
		this.message=message;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getObj() {
		return obj;
	}
	public void setObj(String obj) {
		this.obj = obj;
	}

}
