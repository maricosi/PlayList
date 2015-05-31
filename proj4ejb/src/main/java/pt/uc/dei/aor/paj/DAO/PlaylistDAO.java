package pt.uc.dei.aor.paj.DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import pt.uc.dei.aor.paj.Playlist;
import pt.uc.dei.aor.paj.User;


public class PlaylistDAO extends GenericDAO<Playlist>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3546649238681418940L;


	public PlaylistDAO() {
		super(Playlist.class);
		// TODO Auto-generated constructor stub
	}


	public void deletePlaylist (Playlist playlist){
		super.delete(playlist.getId(), Playlist.class);
	}


	@SuppressWarnings("unchecked")
	public List<Playlist> all(){
		Query query = em.createNamedQuery(Playlist.FIND_ALL);
		return (List<Playlist>)query.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List <Playlist> findByNameASC(String name){
		Query q = em.createNamedQuery(Playlist.FIND_BY_NAME_ASC);
		q.setParameter("name",name);
		return q.getResultList();	
	}
	
	@SuppressWarnings("unchecked")
	public List <Playlist> findByNameDESC(String name){
		Query q = em.createNamedQuery(Playlist.FIND_BY_NAME_DESC);
		q.setParameter("name",name);
		return q.getResultList();	
	}
	
	@SuppressWarnings("unchecked")
	public List <Playlist> findByDateASC(Date date){
		Query q = em.createNamedQuery(Playlist.FIND_BY_DATE_ASC);
		q.setParameter("date",date);
		return q.getResultList();	
	}
	
	@SuppressWarnings("unchecked")
	public List <Playlist> findByDateDESC(Date date){
		Query q = em.createNamedQuery(Playlist.FIND_BY_DATE_DESC);
		q.setParameter("date",date);
		return q.getResultList();	
	}
	
	@SuppressWarnings("unchecked")
	public List <Playlist> findBySizeASC(int size){
		Query q = em.createNamedQuery(Playlist.FIND_BY_SIZE_ASC );
		q.setParameter("size",size);
		return q.getResultList();	
	}
	
	@SuppressWarnings("unchecked")
	public List <Playlist> findBySizeDESC(int size){
		Query q = em.createNamedQuery(Playlist.FIND_BY_SIZE_DESC );
		q.setParameter("size",size);
		return q.getResultList();	
	}
	
	@SuppressWarnings("unchecked")
	public List <User> findUsernamePass(String username, String password){
		Query q = em.createNamedQuery(User.FIND_BY_USERNAME_PASS);
		   q.setParameter("username", username);
	       q.setParameter("password",password);
		
		return q.getResultList();
	}


}





