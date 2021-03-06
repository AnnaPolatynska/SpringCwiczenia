package pl.reaktor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.reaktor.model.Contact;
import pl.reaktor.model.Posts;
import pl.reaktor.model.Register;
import pl.reaktor.repository.RegisterRepo;

@Controller
public class BlogController {

	private RegisterRepo rr;
	
	// w konstruktorze ma utworzyć obiekt rr
	// @Autowired wstrzykuje 
	@Autowired
	public BlogController(RegisterRepo rr){
		this.rr=rr;
	}
	
	
	
	
	@RequestMapping("/")
	public String about(){
		return "about";
	}
	@PostMapping("/blog")
	public String blog(@ModelAttribute Register reg, Model model){
		model.addAttribute("reg", reg);
		List<Register> rs= rr.findAllByLoginAndPasswd(reg.getLogin(), reg.getPasswd());
		if(rs.isEmpty()){
			return "error";
		}else{
		model.addAttribute("post", new Posts());
		return "blog";
		}
		
	}
	@PostMapping("/add")
	public String add(@ModelAttribute Posts post, Model model){
		model.addAttribute("post", post);	
		return "add";
	}
	@RequestMapping("/contact")
	public String contact(Model model){
		model.addAttribute("c", new Contact());
		return "contact";
	}
	@PostMapping("/success")
	public String success(@ModelAttribute Contact c, Model model){
		model.addAttribute("c",c);	
		return "success";
	}
	
	// dodajemy formularz rejestracyjny widok registerForm ma pola reg.login i reg.password zapisze w bd i wyświtli się widok save
	@RequestMapping("/registerForm")
	public String registerForm(Model model){
		model.addAttribute("reg", new Register());
		return "registerForm";
	}
	
	//przekierowanie się na widok save   wywołanie domyślnego konstruktora Register
	@PostMapping("/saveRegister")
	public String saveRegister(@ModelAttribute Register reg, Model model){
		// połączenie z bd rr.save na obiekcie reg
		// zapisujemy na obiekcie repo na górze + tworzymy  Register repo
		rr.save(reg);
		
		//niżej to koniec do widoku
		model.addAttribute("reg", reg); //do modelu dodaję obiekt klasy register =reg a "reg"to podręczn nazwa nawidoku
		return "saveRegister";
	}
	//po rejestracji logowanie
	@RequestMapping("/loginForm")
	public String loginForm(Model model){
		model.addAttribute("reg", new Register());
		return "loginForm";
	}
	
	
	//chcemy odczytać z bazy danych
	
	
	
	
	
}
