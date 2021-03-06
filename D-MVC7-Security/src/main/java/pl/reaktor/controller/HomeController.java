package pl.reaktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//Using default security password: 67b90d2d-1fff-4820-8fc5-84e0ac548c75 z defoltu hasło dla user
//daje dostęp do np obrazka 
//można nadać hasło w application.properties

	@Controller
	public class HomeController {
	@RequestMapping("/")
	public String home(){
		return"home";
		}
	
	@RequestMapping("/secured")
	public String secured(){
		return"secured";
	}
	
	//super zabezpieczenia przed wpisaniem bezpośrednio z url
	@RequestMapping("/supersecured")
	public String supersecured(){
		return "supersecured";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm(){
		return "loginForm";
	}
}