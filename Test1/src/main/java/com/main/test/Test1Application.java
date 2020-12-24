package com.main.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.main.test.repository.StudentInterface;

@SpringBootApplication
public class Test1Application  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpringApplication.run(Test1Application.class, args);

	}

}
