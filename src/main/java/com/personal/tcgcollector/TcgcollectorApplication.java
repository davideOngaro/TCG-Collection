package com.personal.tcgcollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TcgcollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcgcollectorApplication.class, args);
	}

}
