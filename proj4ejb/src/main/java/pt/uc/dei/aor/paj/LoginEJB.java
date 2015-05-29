package pt.uc.dei.aor.paj;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pt.uc.dei.aor.paj.User;

public class LoginEJB {
	
	@PersistenceContext(name = "Utilizador")
	private EntityManager em;


	public LoginEJB() {
		super();
		
	}

	public boolean verificarUser (String username,String password){
		boolean verificarUser=false;
		Query q =em.createQuery("from User1 u where u.name like :username and u.password like :password" );
		q.setParameter("username", username);
		q.setParameter("password", password);
		
		List<User1> user=q.getResultList();
		
		if(user.size()==0){
			verificarUser=false;
		} else if(user.size()!=0){
			verificarUser=true;
		}
		
		return verificarUser;
		
	}

}
