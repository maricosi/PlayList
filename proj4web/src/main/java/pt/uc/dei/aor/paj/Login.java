package pt.uc.dei.aor.paj;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.paj.fachada.IntUserFachada;

@Named
@RequestScoped
public class Login {
	

	@EJB
	private IntUserFachada user;
	private String username;
	private String password;
	private String mensagem="";
	private boolean loged=false;

	private static final Logger logger = LoggerFactory.getLogger(Login.class);

	public Login() {
		super();
	}

/*	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}*/

	public void validate (){
		this.setMensagem(user.validate(username, password));
		if(mensagem.equals("User logado!!")){
			this.loged=true;
			logger.debug("Utilizador com "+username + "e" + password+ "logado");
		} else {
			this.loged=false;
			logger.debug("Alguém está a tentar aceder a conta com " + username + " e " + password);
		}
		

	}

	public Boolean getLoged() {
		return loged;
	}

	public void setLoged(boolean loged) {
		this.loged = loged;
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

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}