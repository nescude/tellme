package com.nescude.tellme;

import com.nescude.tellme.services.TwitterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TellmeApplication implements CommandLineRunner{

	// @Autowired
	// TwitterService service;

	public static void main(String[] args) {
		SpringApplication.run(TellmeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//service.getTweetById(20);
	}

}
