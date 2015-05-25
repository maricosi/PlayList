package pt.uc.dei.aor.paj;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@RequestScoped
public class Login2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserEJB userEJB;
	private String username;
	private String password;

	private static final Logger logger = LoggerFactory.getLogger(UserEJB.class);

	public Login2() {
		super();
	}

	public Login2(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void populate() {
		logger.debug("ja foste");
		userEJB.populate();
	}

	public List<User> getUsers() {
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