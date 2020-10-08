package io.shakespeare.playwright;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.shakespeare.playwright.utilities.WordFormMapper;

@SpringBootApplication
public class PlaywrightApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaywrightApplication.class, args);
	}

}
