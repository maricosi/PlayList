package pt.uc.dei.aor.paj.DAO;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pt.uc.dei.aor.paj.Playlist;
import pt.uc.dei.aor.paj.Utilizador;

@Stateless
public class PlaylistDAO extends GenericDAO<Playlist>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3546649238681418940L;


	public PlaylistDAO() {
		super(Playlist.class);
		// TODO Auto-generated constructor stub
	}


	@SuppressWarnings("unchecked")
	public List<Playlist> all(){
		Query query = em.createNamedQuery(Playlist.FIND_ALL);
		return (List<Playlist>)query.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List <Playlist> orderByNameASC(Utilizador utilizador){
		Query q = em.createNamedQuery(Playlist.ORDER_BY_NAME_ASC);
		q.setParameter("utilizador",utilizador);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List <Playlist> orderByNameDESC(Utilizador utilizador){
		Query q = em.createNamedQuery(Playlist.ORDER_BY_NAME_DESC);
		q.setParameter("utilizador",utilizador);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List <Playlist> orderByDateASC(Utilizador utilizador){
		Query q = em.createNamedQuery(Playlist.ORDER_BY_DATE_ASC);
		q.setParameter("utilizador",utilizador);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List <Playlist> orderByDateDESC(Utilizador utilizador){
		Query q = em.createNamedQuery(Playlist.ORDER_BY_DATE_DESC);
		q.setParameter("utilizador",utilizador);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List <Playlist> orderBySizeASC(Utilizador utilizador){
		Query q = em.createNamedQuery(Playlist.ORDER_BY_SIZE_ASC );
		q.setParameter("utilizador",utilizador);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List <Playlist> orderBySizeDESC(Utilizador utilizador){
		Query q = em.createNamedQuery(Playlist.ORDER_BY_SIZE_DESC );
		q.setParameter("utilizador",utilizador);
		return q.getResultList();	
	}
	
	@SuppressWarnings("unchecked")
	public List <Utilizador> findUsernamePass(String username, String password){
		Query q = em.createNamedQuery(Utilizador.FIND_BY_USERNAME_PASS);
		   q.setParameter("username", username);
	       q.setParameter("password",password);
		
		return q.getResultList();
	}

	
	@SuppressWarnings("unchecked")
	public List<Playlist> findNameUtilizador(String name, Utilizador utilizador) {
		Query q = em.createNamedQuery(Playlist.FIND_BY_NAME_UTILIZADOR);
		   q.setParameter("name", name);
	       q.setParameter("utilizador",utilizador);
		return q.getResultList();
	}


	@SuppressWarnings("unchecked")
	public List<Playlist> findByUtilizador(Utilizador utilizador) {
		Query q = em.createNamedQuery(Playlist.FIND_BY_UTILIZADOR);
	       q.setParameter("utilizador",utilizador);
		return q.getResultList();
	}
	
}





