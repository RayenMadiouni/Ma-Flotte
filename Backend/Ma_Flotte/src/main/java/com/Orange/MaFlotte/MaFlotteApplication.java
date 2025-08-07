package com.Orange.MaFlotte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class   MaFlotteApplication {

	public static void main(String[] args) {

		SpringApplication.run(MaFlotteApplication.class, args);
	}

}
