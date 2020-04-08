package com.springdatarest.memory.overflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.mapping.ResourceMappings;

import java.util.Vector;

@SpringBootApplication
public class OverflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OverflowApplication.class, args);
	}
}
