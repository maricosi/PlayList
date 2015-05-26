package pt.uc.dei.aor.paj;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


	
	abstract class GenericDAO<T> implements Serializable{

		private static final long serialVersionUID = -7473203207346198235L;
		
		private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MUDAR O NOME");
	    private EntityManager em;
	    
	    private Class<T> entityClass;
	    
	    public GenericDAO(Class<T> entityClass) {
	        this.entityClass = entityClass;
	    }
	    
	    public void beginTransaction() {
	        em = emf.createEntityManager();	 
	        em.getTransaction().begin();
	    }

		public void delete(Object id, Class<T> classe) {
			 T entityToBeRemoved = em.getReference(classe, id);			 
			 em.remove(entityToBeRemoved);			
		}

//		public T update(T entityClass) {
//	        return em.merge(entityClass);
//	    }
		
		 public void update(T entityClass) {
		        em.merge(entityClass);
		    }
		
		public List<T> all(){
			return em.createQuery("t from T t", entityClass).getResultList();
		}

	
		
		
	
		
}
