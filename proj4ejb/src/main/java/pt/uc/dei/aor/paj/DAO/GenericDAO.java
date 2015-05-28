package pt.uc.dei.aor.paj.DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;



public abstract class GenericDAO<T> implements Serializable{

	private static final long serialVersionUID = -7473203207346198235L;

	@PersistenceContext(unitName = "Proj4")
	protected EntityManager em;

	private Class<T> entityClass;

	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

/*	public void beginTransaction() {

		emf.createEntityManager();	 
		em.getTransaction().begin();
	}
*/
	public void delete(Object id, Class<T> classe) {
		T entityToBeRemoved = em.getReference(classe, id);			 
		em.remove(entityToBeRemoved);			
	}

	public void update(T entityClass) {
		em.merge(entityClass);
	}
	
	 public T find(int entityID) {
	        return em.find(entityClass, entityID);
	    }

    public void save(T entity) {
        em.persist(entity);
    }




}
