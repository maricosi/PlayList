package pt.uc.dei.aor.paj.fachada;

import java.util.List;
import javax.ejb.EJB;
import pt.uc.dei.aor.paj.User;
import pt.uc.dei.aor.paj.DAO.UserDAO;



public class UserFachada implements IntUserFachada {

	@EJB
	private UserDAO userDAO;

	public String save(String name, String username, String email, String password) {
		User user =new User(name,username,email,password);
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

	private boolean isUserExist(String email, String username){
		boolean exist=false;
		String mensagemErro="";

		if 


		return false;



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
