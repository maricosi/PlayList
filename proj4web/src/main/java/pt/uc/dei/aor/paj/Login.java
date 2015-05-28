package pt.uc.dei.aor.paj;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.paj.DAO.UserDAO;

@Named
@RequestScoped
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	//private LoginEJB loginEJB;
	private UserEJB userEJB;
	private String username;
	private String password;
	private boolean loged=false;

	private static final Logger logger = LoggerFactory.getLogger(UserEJB.class);

	public Login() {
		super();
	}

	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Boolean getLoged() {
		return loged;
	}

	public void setLoged(boolean loged) {
		this.loged = loged;
	}

	public void populate() {
		logger.debug("ja foste");
		userEJB.populate();
	}
	
/*	public boolean verifcacaoLogin(String username, String password){
		loged=loginEJB.verificarUser(username, password);
		
		return loged;
		
	}*/

	public List<UserDAO> getUsers() {
		return userEJB.getUsers();
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

}