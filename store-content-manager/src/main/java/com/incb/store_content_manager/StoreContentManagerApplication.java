package com.incb.store_content_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StoreContentManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreContentManagerApplication.class, args);
	}

}
