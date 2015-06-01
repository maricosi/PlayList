package pt.uc.dei.aor.paj;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.paj.fachada.IntUserFachada;

import java.io.Serializable;

@Named
@SessionScoped
public class Login implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IntUserFachada user;
	private String username;
	private String password;
	private String mensagem="";
	private boolean logged=false;

	private static final Logger logger = LoggerFactory.getLogger(Login.class);

	public Login() {
		super();
	}

	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	

	public void validate (){
		this.setMensagem(user.validate(username, password));
		if(mensagem.equals("User logado!!")){
			this.logged=true;
			logger.debug("Utilizador com "+username + "e" + password+ "logado");
			HttpSession session= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("loggedin",true);
			session.setMaxInactiveInterval(60);
		} else {
			this.logged=false;
			logger.debug("Alguém está a tentar aceder a conta com " + username + " e " + password);
		}
	}
	
	
	public void logout (){
		this.logged=false;
		this.mensagem="";
		this.username="";
		this.password="";
	}

	public Boolean getLoged() {
		return logged;
	}

	public void setLoged(boolean loged) {
		this.logged = loged;
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