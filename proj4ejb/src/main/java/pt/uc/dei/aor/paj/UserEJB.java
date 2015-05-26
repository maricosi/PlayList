package pt.uc.dei.aor.paj;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.paj.User1;

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
		System.out.println("OLA");
		logger.trace("dsnklan");
		logger.debug("Sample debug message");
		logger.info("Sample info message");
		logger.warn("Sample warn message");
		logger.error("Sample error message");
		em.persist(new User1("Filipa", "123", "filipapedrosa@gmail.com"));
		em.persist(new User1("Marisa", "456", "marisaisimoes@gmail.com"));
	}

	public List<User1> getUsers() {
		// List<String> usernames = new LinkedList<>();

		Query q = em.createQuery("from User u");
		List<User1> users = q.getResultList();

		// for (User u : users) {
		// usernames.add(u.toString());
		// }

		return users;
	}
}