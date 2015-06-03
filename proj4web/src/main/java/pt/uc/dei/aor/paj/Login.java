package pt.uc.dei.aor.paj;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.paj.fachada.IntUserFachada;

import java.io.IOException;
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
	private String nome;
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
	

	public String validate () throws IOException{
		String mensagemFachada=(user.validate(username, password));
		if(mensagemFachada.equals("User logado!!")){
			this.mensagem="Olá " +user.nameUser(username, password)+ "!!!";
			this.logged=true;
			logger.debug("Utilizador com "+username + "e" + password+ "logado");
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			HttpSession sessao= (HttpSession) ec.getSession(true);
			sessao.setAttribute("loggedin", true);
			ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
			return "index.xhtml";
		} else {
			this.mensagem=mensagemFachada;
			this.logged=false;
			logger.debug("Alguém está a tentar aceder a conta com " + username + " e " + password);
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
			return "login.xhtml";
		}		
	}
	
	
	public void logout () throws IOException{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();
		this.logged=false;
		this.mensagem="";
		this.username="";
		this.password="";
		ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
	}

	public Boolean getLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
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
		this.password =password;
	}
	

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

}