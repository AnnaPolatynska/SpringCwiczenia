package pl.reaktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class BlogController {
	
	

	
		@GetMapping("/")
		public String blog(){
			return "blog";
		}
		
		@RequestMapping("/kontakt")
		public String kontakt(){
			return "kontakt";
			}
		
		@RequestMapping("/oMnie")
		public String oMnie(){
			return "oMnie";
			}
		
	}

