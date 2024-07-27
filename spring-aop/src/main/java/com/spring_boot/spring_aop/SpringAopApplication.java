package com.spring_boot.spring_aop;

import com.spring_boot.spring_aop.aopexample.BusinessService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

	private BusinessService1 businessService1;

	private Logger logger = LoggerFactory.getLogger(getClass());
	public SpringAopApplication(BusinessService1 businessService1) {
		this.businessService1 = businessService1;

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Max value is {}", this.businessService1.calculateMax());

	}
}
