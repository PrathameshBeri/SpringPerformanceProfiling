package io.shakespeare.playwright.utilities;

public enum Constants {

	INDIA("Asia/Calcutta");

	private String value;

	Constants(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
