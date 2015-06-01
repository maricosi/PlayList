package pt.uc.dei.aor.paj.fachada;

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
		User user =new User(name,email,username,password);
		System.out.println(name+" "+username+" "+email+" "+password);
		try{
			isUserWithAllData(user);
			userDAO.save(user);
			return "Utilizador criado com sucesso";
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
			List<User> user= userDAO.findUsernamePass(username,password);
			if(user.size()==0){
				mensagem="User inexistente!!";
			} else if(user.size()!=0){
				mensagem= "User logado!!";
			}
			return mensagem;
		} catch (IllegalArgumentException e){
			return e.getMessage();
		}

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
