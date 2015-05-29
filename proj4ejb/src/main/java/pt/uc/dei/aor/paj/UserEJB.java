package pt.uc.dei.aor.paj;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.paj.User1;
import pt.uc.dei.aor.paj.DAO.UserDAO;

/**
 * Session Bean implementation class UserEJB
 */
@Stateless
public class UserEJB {

	@PersistenceContext(name = "Utilizador")
	private EntityManager em;

	private static final Logger logger = LoggerFactory.getLogger(UserEJB.class);

	public UserEJB() {
		// TODO Auto-generated constructor stub
	}

	public void populate() {
		logger.trace("dsnklan");
		logger.debug("Sample debug message");
		logger.info("Sample info message");
		logger.warn("Sample warn message");
		logger.error("Sample error message");
		em.persist(new User1("Filipa", "123", "filipapedrosa@gmail.com"));
		em.persist(new User1("Marisa", "456", "marisaisimoes@gmail.com"));
	}

	
/*	public List<UserDAO> getUsers() {
		List<UserDAO> userDAOS = new LinkedList<>();

		Query q = em.createQuery("from User1 u");
		List<User1> users = q.getResultList();
		logger.info(users.size()+" ejb");
		
		for (User1 u : users) {
			userDAOS.add(new UserDAO(u.getName(),u.getEmail()));
		}

		return userDAOS;
	}
	*/
}