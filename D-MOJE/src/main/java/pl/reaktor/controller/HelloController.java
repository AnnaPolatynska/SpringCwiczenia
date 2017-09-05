package pl.reaktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//wywołanie controllera że nie jest to inna clasa + wymaga importu, uruchomi się w momencie odpalenia programu
@Controller 
public class HelloController {

	//z jakiego adresu ma pobrać dane/ żądanie typu get
	
	@RequestMapping("/")
	//@ResponseBody
	public String hello(){
		return "hello";
	}
	
	//wywołanie to kliknięcie na D-MVC prawy klawisz -> run as-> SpringBootApp
	
	//2 metoda
	//@GetMapping("/")
	//public String hello(){
	//	return "hello";
	//}
	
}
