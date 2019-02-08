package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/hello/rest")
	public  MyClass home(){
		MyClass ret = new MyClass();
		ret.setAge(1);
		ret.setName("kjy");
		ret.setSchool("KNU");
		return ret;
	}
}

class MyClass{
	@Getter @Setter String name;
	@Getter @Setter int age;
	@Getter @Setter String school;
}
