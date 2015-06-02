package pt.uc.dei.aor.paj.fachada;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.paj.Utilizador;
import pt.uc.dei.aor.paj.DAO.UserDAO;


@Stateless
public class UserFachada implements IntUserFachada {

	@EJB
	private UserDAO userDAO;

	public String save(String name, String username, String email, String password) {
		String mensagemRegisto="";
		Utilizador utilizador =new Utilizador(name,email,username,password);
		System.out.println(name+" "+username+" "+email+" "+password);
		try{
			isUserWithAllData(utilizador);
			String passwordEncript=(passwordEncrip(password));
			utilizador.setPassword(passwordEncript);
			List<Utilizador> userUsername= userDAO.findUsername(username);
			System.out.println(userUsername);
			List<Utilizador> userEmail= userDAO.findEmail(email);
			if(userUsername==null && userEmail==null ){
				userDAO.save(utilizador);
				mensagemRegisto="Utilizador criado com sucesso";
			}else if(userUsername.size()==0 && userEmail.size()==0 ){
				userDAO.save(utilizador);
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

	private boolean isUserWithAllData(Utilizador utilizador) {
		boolean hasError = false;
		String mensagemErro="";

		if(utilizador == null){
			hasError = true;
			mensagemErro="Erro!!";
		}
		else {

			if (utilizador.getName() == null || "".equals(utilizador.getName().trim())){
				hasError = true;
				mensagemErro=mensagemErro+"Nome ";
			}

			if(utilizador.getUsername()== null || "".equals(utilizador.getUsername().trim())){
				hasError = true;
				mensagemErro=mensagemErro+"Username ";
			}

			if(utilizador.getPassword() == null || "".equals(utilizador.getPassword().trim())){
				hasError = true;
				mensagemErro=mensagemErro+"Password ";
			}

			if(utilizador.getEmail()== null || "".equals(utilizador.getEmail().trim())){
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
			List<Utilizador> utilizador= userDAO.findUsernamePass(username,passwordEncript);
			if(utilizador.size()==0){
				mensagem="Autenticação inválida!!";
			} else if(utilizador.size()!=0){
				mensagem="User logado!!";
			}
			return mensagem;
		} catch (IllegalArgumentException e){
			return e.getMessage();
		}

	}

	public String nameUser(String username, String password){
		String passwordEncript=(passwordEncrip(password));
		List<Utilizador> utilizadors= userDAO.findUsernamePass(username,passwordEncript);
		return utilizadors.get(0).getName();
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
	public Utilizador update(Utilizador utilizador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Utilizador utilizador) {
		// TODO Auto-generated method stub

	}

	@Override
	public Utilizador find(int entityID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilizador> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
