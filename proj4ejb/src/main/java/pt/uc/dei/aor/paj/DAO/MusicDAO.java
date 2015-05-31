package pt.uc.dei.aor.paj.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pt.uc.dei.aor.paj.Music;
import pt.uc.dei.aor.paj.Playlist;
import pt.uc.dei.aor.paj.User;

@Stateless
public class MusicDAO extends GenericDAO<Music> {

	private static final long serialVersionUID = -5948663054664365492L;



	public MusicDAO(){
		super(Music.class);

	}

	public Music find (Music music) {
		return super.find(music.getId());
	}

	@SuppressWarnings("unchecked")
	public List<Music> all(){
		Query query = em.createNamedQuery(Music.FIND_ALL);
		return (List<Music>)query.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List <Music> findByArtist(String artist){
		Query q = em.createNamedQuery(Music.FIND_BY_ARTIST);
		q.setParameter("artist",artist);
		return q.getResultList();	
	}

	@SuppressWarnings("unchecked")
	public List <Music> findByTitle(String title){
		Query q = em.createNamedQuery(Music.FIND_BY_TITLE);
		q.setParameter("title",title);
		return q.getResultList();	
	}


	@SuppressWarnings("unchecked")
	public List <Music> findByAlbum(String album){
		Query q = em.createNamedQuery(Music.FIND_BY_ALBUM);
		q.setParameter("album",album);
		return q.getResultList();	
	}

	@SuppressWarnings("unchecked")
	public List <Music> findByYear(int year){
		Query q = em.createNamedQuery(Music.FIND_BY_YEAR);
		q.setParameter("year",year);
		return q.getResultList();	
	}

	@SuppressWarnings("unchecked")
	public List <Music> findByUser(int year){
		Query q = em.createNamedQuery(Music.FIND_BY_YEAR);
		q.setParameter("year",year);
		return q.getResultList();	
	}

	@SuppressWarnings("unchecked")
	public List <Music> findByUser(String username, String password){
		User user1=(User) findUsernamePass(username, password);
		Query q = em.createNamedQuery(Music.FIND_BY_USER);
		q.setParameter("user",user1);
		return q.getResultList();	
	}

	@SuppressWarnings("unchecked")
	public List<User> findUsernamePass(String username, String password) {
		Query q = em.createNamedQuery(User.FIND_BY_USERNAME_PASS);
		   q.setParameter("username", username);
	       q.setParameter("password",password);
		
		return q.getResultList();
	}
	
}
