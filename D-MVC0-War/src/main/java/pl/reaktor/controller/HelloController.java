package pl.reaktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	public String hello(){
		return "hello";
	}
	@RequestMapping("/info")
	public String info(){
		return "info";
	}
	@RequestMapping("/hello")
	public String hello2(){
		return "hello";
	}

}
