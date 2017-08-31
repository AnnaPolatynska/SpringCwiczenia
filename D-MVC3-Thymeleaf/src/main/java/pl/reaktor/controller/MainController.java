package pl.reaktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.reaktor.model.Register;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home(Model model){
		model.addAttribute("reg", new Register());
		return"home";
		
		
	}
	
	@PostMapping("/result")
	public String result(@ModelAttribute Register reg, Model model){
		model.addAttribute("reg",reg);
		//pobiera obiekt reg i jego nazwa na widoku
		//reg.setLogin(reg.getLogin()+" "); //dodaje spacje po zmiennej login
		
		//jeżeli wypelniam dobrze login >5 znaków to idę do result jak żle to home
		if (reg.getLogin().length() >=5){
			return "result"; //wywołanie widoku
		}else{
			return "redirect:/"; // przekierowanie do metody na adres www
		}
		
		
	}
	
	
}
