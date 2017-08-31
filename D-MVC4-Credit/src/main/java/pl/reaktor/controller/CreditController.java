package pl.reaktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.reaktor.model.Credit;

@Controller
public class CreditController {

	@RequestMapping("/")
	public String creditForm(Model model){
		model.addAttribute("credit", new Credit());
		return "creditForm";
	}
	@RequestMapping("/result")
	public String creditForm(@ModelAttribute Credit credit, Model model){	
			if(credit.getKwota_kredyt() >= 100000){
				credit.setProcent(0.08);
			}
			return "result";	
	}
	
	
}
