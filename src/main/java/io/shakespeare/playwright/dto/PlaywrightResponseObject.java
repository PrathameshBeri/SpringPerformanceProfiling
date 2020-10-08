package io.shakespeare.playwright.dto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import io.shakespeare.playwright.utilities.Constants;

public class PlaywrightResponseObject<T> {

	T data;
	String message;
	String url;
	String time;

	public PlaywrightResponseObject(T data, String message, String url) {
		super();
		this.data = data;
		this.message = message;
		this.url = url;
		ZonedDateTime zonedt = ZonedDateTime.now(ZoneId.of(Constants.INDIA.getValue()));
		this.time = zonedt.toString();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
