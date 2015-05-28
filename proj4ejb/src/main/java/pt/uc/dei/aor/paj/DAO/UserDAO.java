package pt.uc.dei.aor.paj.DAO;

import pt.uc.dei.aor.paj.User;



public class UserDAO extends GenericDAO<User>{

	private static final long serialVersionUID = -7769472638184179598L;
	private String username, email;
	
	public UserDAO(String username, String email) {
		super(User.class);
		this.username = username;
		this.email = email;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	

	
	



}
