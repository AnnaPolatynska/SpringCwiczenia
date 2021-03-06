package pl.reaktor.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http 
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/contact").permitAll()
			.antMatchers("/success").permitAll()
			.antMatchers("/registerForm").permitAll()
			.antMatchers("/saveRegister").permitAll()
			.antMatchers("/errorPage").permitAll()
			.antMatchers("/blog").permitAll()
			.antMatchers("/add").permitAll()
			.anyRequest().authenticated()
		.and()
		
			.formLogin()
			.loginPage("/loginForm").permitAll()
			.loginProcessingUrl("/processlogin").permitAll()
		.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
			
			
			
	}

	private ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl loginProcessingUrl(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
