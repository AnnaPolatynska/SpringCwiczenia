package pl.reaktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class HelloController {

		//@RequestMapping("/") metoda bez powrotu  @GetMapping gdy chcemy wrócić do strony
		
		@GetMapping("/")
		public String hello(){
			return "hello";
		}
		
		@RequestMapping("/info")
		public String info(){
			return "info";
			}
}
