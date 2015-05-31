package pt.uc.dei.aor.paj.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pt.uc.dei.aor.paj.User;



@Stateless
public class UserDAO extends GenericDAO<User> {

	private static final long serialVersionUID = 6917832142336265801L;

	public UserDAO(){
		super(User.class);

	}

	public User find (User user) {
		return super.find(user.getId());
	}

	@SuppressWarnings("unchecked")
	public List <User> findUsernamePass(String username, String password){
		Query q = em.createNamedQuery(User.FIND_BY_USERNAME_PASS);
		   q.setParameter("username", username);
	       q.setParameter("password",password);
		
		return q.getResultList();
		
	}


}




	

	
	




