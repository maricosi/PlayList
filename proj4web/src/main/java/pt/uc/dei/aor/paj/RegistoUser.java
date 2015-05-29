package pt.uc.dei.aor.paj;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pt.uc.dei.aor.paj.fachada.IntUserFachada;

@Named
@RequestScoped
public class RegistoUser {
	@EJB
	private IntUserFachada user;
	private String name;
	private String username;
	private String password;
	private String verifyPassword;
	private String email;
	private String mensagem="";
	
	
	public RegistoUser() {
		super();
	}


	public RegistoUser(String name, String username, String password, String verifyPassword,
			String email, String mensagem) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mensagem = mensagem;
	}

	public void registUser (){
		if (verifyPassword.equals(password)){
			this.mensagem=user.save(name, username, email, password);
		} else {
			this.mensagem="Passwords não coincidem!!";
		}	
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getVerifyPassword() {
		return verifyPassword;
	}


	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	
	
}
