package com.lsepu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		var ctx = SpringApplication.run(DemoApplication.class, args);
		TestClass testClass = ctx.getBean("testBean",TestClass.class);
		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);

		System.out.println(testClass.showHello());
		System.out.println(myFirstService.sayHello());
	}

}
