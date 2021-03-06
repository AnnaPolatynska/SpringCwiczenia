package pl.reaktor.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;




//nazwa klasy musi być dokłanie SecurityConfig
	@Configuration
	public class SecurityConfig extends WebSecurityConfigurerAdapter {
//chcę przeciążyć swoją konfiguracją
//gdy / niechronione i wymaga logowania by przejśc do /secured
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
//nieuwierzytelnione dla poniższych url("/")
		http.authorizeRequests()
		.antMatchers("/").permitAll()
//uwierzytelnienie dla każdego innego adresu url
		.anyRequest().authenticated()
//korzystamy z dostępnego formularza logowania adres logowania w loginPage
		.and().formLogin().loginPage("/loginForm").
//to action z formularza
		loginProcessingUrl("/processLogin").permitAll()
//wylogowywanie . adres do wylogowywania. adres na który się przenosimy
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
		
	}
	
	
	
	
}
