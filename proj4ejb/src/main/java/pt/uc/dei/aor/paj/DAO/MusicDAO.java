package pt.uc.dei.aor.paj.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pt.uc.dei.aor.paj.Music;
import pt.uc.dei.aor.paj.Utilizador;

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
	public List <Music> findByTitleArtist(String title,String artist){
		Query q = em.createNamedQuery(Music.FIND_BY_TITLE_ARTIST);
		q.setParameter("title","%"+title+"%");
		q.setParameter("artist","%"+artist+"%");
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

/*	@SuppressWarnings("unchecked")
	public List <Music> findByUser(int year){
		Query q = em.createNamedQuery(Music.FIND_BY_YEAR);
		q.setParameter("year",year);
		return q.getResultList();	
	}*/

	@SuppressWarnings("unchecked")
	public List <Music> findByUtilizador(String username){
		System.out.println("Estou no music dao");
		List<Utilizador> lista = findUsername(username);
		System.out.println("USERS ENCONTRADOS: " + lista);
		Utilizador user1= lista.get(0);
		System.out.println("Utilizador"+user1);
		Query q = em.createNamedQuery(Music.FIND_BY_UTILIZADOR);
		q.setParameter("utilizador",user1);
		return q.getResultList();	
	}

	@SuppressWarnings("unchecked")
	public List<Utilizador> findUsernamePass(String username, String password) {
		Query q = em.createNamedQuery(Utilizador.FIND_BY_USERNAME_PASS);
		   q.setParameter("username", username);
	       q.setParameter("password",password);
		
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Utilizador> findUsername(String username) {
		Query q = em.createNamedQuery(Utilizador.FIND_BY_USERNAME);
		   q.setParameter("username", username);

		return q.getResultList();
	}
	
	public void idMusicaUtilizadorZero(List<Music> musica){
		for (Music m:musica){
			m.setUtilizador(null);
			update(m);
		}
	}
	
}
