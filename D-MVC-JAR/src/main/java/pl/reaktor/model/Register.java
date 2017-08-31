package pl.reaktor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//ma być tblelą = encją w bd
@Entity
public class Register {
//podczas rejestracji wpisz:
	// co będzie kluczem
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String login;
	private String passwd;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public Register() {}
	
	public Register(String login, String passwd) {
		super();
		this.login = login;
		this.passwd = passwd;
	}
	
	
	
	
	
}
