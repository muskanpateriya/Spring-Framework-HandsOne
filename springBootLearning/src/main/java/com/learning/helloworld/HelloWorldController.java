package com.learning.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//basic
@RestController
public class HelloWorldController {

	@GetMapping("/hello-muttu")
	public String helloWorld() {
		return "Meri muttu baby umh.........";
	}

	@GetMapping("/hello-muttu-bean")
	public HelloMuttuBean helloWorldBean() {
		return new HelloMuttuBean("Meri muttu baby umh.........");
	}

}
