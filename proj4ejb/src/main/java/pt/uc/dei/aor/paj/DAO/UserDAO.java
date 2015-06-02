package pt.uc.dei.aor.paj.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pt.uc.dei.aor.paj.Utilizador;



@Stateless
public class UserDAO extends GenericDAO<Utilizador> {

	private static final long serialVersionUID = 6917832142336265801L;

	public UserDAO(){
		super(Utilizador.class);

	}

	public Utilizador find (Utilizador utilizador) {
		return super.find(utilizador.getId());
	}

	@SuppressWarnings("unchecked")
	public List <Utilizador> findUsernamePass(String username, String password){
		Query q = em.createNamedQuery(Utilizador.FIND_BY_USERNAME_PASS);
		   q.setParameter("username", username);
	       q.setParameter("password",password);
		
		return q.getResultList();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Utilizador> findUsername(String username){
		Query q = em.createNamedQuery(Utilizador.FIND_BY_USERNAME);
		   q.setParameter("username", username);		   
			return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Utilizador> findEmail(String email){
		Query q = em.createNamedQuery(Utilizador.FIND_BY_EMAIL);
		   q.setParameter("email", email);		   
			return q.getResultList();
	}
	
}




	

	
	




