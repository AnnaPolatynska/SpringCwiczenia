package pl.reaktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.reaktor.model.Kredyt;

@Controller
public class BankController {
	
	@RequestMapping("/")
	public String kredyt(Model model){
		model.addAllAttribute("kredyt" new Kredyt());
		return "kredyt";
	}
	
	@RequestMapping("/result")
	public String blog(@ModelAttribute Kredyt kredyt, Model model){
		model.addAttribute("kredyt", kredyt);
		return "result";
	}
	
}
