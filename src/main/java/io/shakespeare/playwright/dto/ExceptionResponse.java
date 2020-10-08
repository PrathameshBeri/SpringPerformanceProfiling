package io.shakespeare.playwright.dto;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import io.shakespeare.playwright.utilities.Constants;

public class ExceptionResponse {

	String description;
	String dateTime;
	String message;

	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(String description, String message) {
		super();
		this.description = description;
		this.dateTime = ZonedDateTime.now(ZoneId.of(Constants.INDIA.getValue())).toString();
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
