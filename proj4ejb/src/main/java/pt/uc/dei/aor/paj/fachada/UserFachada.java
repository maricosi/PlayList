package pt.uc.dei.aor.paj.fachada;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.paj.User;
import pt.uc.dei.aor.paj.DAO.UserDAO;


@Stateless
public class UserFachada implements IntUserFachada {

	@EJB
	private UserDAO userDAO;

	public String save(String name, String username, String email, String password) {
		String mensagemRegisto="";
		User user =new User(name,email,username,password);
		System.out.println(name+" "+username+" "+email+" "+password);
		try{
			isUserWithAllData(user);
			String passwordEncript=(passwordEncrip(password));
			user.setPassword(passwordEncript);
			List<User> userUsername= userDAO.findUsername(username);
			System.out.println(userUsername);
			List<User> userEmail= userDAO.findEmail(email);
			if(userUsername==null && userEmail==null ){
				userDAO.save(user);
				mensagemRegisto="Utilizador criado com sucesso";
			}else if(userUsername.size()==0 && userEmail.size()==0 ){
				userDAO.save(user);
				mensagemRegisto="Utilizador criado com sucesso";
			}else if(userUsername.size()==1 && userEmail.size()==0){
				mensagemRegisto="Username existente!!";
			}else if(userUsername.size()==0 && userEmail.size()==1){
				mensagemRegisto="Email existente!!";
			}else if(userUsername.size()==1 && userEmail.size()==1){
				mensagemRegisto="Username e Email existente!!";
			}
			return mensagemRegisto;
		} catch (IllegalArgumentException e){
			return e.getMessage();
		}
	}

	private boolean isUserWithAllData(User user) {
		boolean hasError = false;
		String mensagemErro="";

		if(user == null){
			hasError = true;
			mensagemErro="Erro!!";
		}
		else {

			if (user.getName() == null || "".equals(user.getName().trim())){
				hasError = true;
				mensagemErro=mensagemErro+"Nome ";
			}

			if(user.getUsername()== null || "".equals(user.getUsername().trim())){
				hasError = true;
				mensagemErro=mensagemErro+"Username ";
			}

			if(user.getPassword() == null || "".equals(user.getPassword().trim())){
				hasError = true;
				mensagemErro=mensagemErro+"Password ";
			}

			if(user.getEmail()== null || "".equals(user.getEmail().trim())){
				hasError = true;
				mensagemErro=mensagemErro+"Email ";
			}
		}
		if (hasError){
			throw new IllegalArgumentException("Prencha o(s) campo(s): " + mensagemErro + "!!!");
		}

		return !hasError;
	}



	public String validate(String username, String password){
		String mensagem="";
		try{
			isUserLoginWithAllData(username, password);
			String passwordEncript=(passwordEncrip(password));
			List<User> user= userDAO.findUsernamePass(username,passwordEncript);
			if(user.size()==0){
				mensagem="User inexistente!!";
			} else if(user.size()!=0){
				mensagem="User logado!!";
			}
			return mensagem;
		} catch (IllegalArgumentException e){
			return e.getMessage();
		}

	}

	public String nameUser(String username, String password){
		String passwordEncript=(passwordEncrip(password));
		List<User> users= userDAO.findUsernamePass(username,passwordEncript);
		return users.get(0).getName();
	}

	private boolean isUserLoginWithAllData(String username, String password) {
		boolean hasError = false;
		String mensagemErro="";


		if ( "".equals(username)){
			hasError = true;
			mensagemErro=mensagemErro+"Username ";
		}

		if( "".equals(password)){
			hasError = true;
			mensagemErro=mensagemErro+"Password ";
		}

		if (hasError){
			throw new IllegalArgumentException("Prencha o(s) campo(s): " + mensagemErro + "!!!");
		}

		return !hasError;

	}

	private String passwordEncrip(String password){
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++){
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
			return generatedPassword;
		}
		catch (NoSuchAlgorithmException e)
		{
			return e.getMessage();
		}
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User find(int entityID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
