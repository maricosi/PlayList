package pt.uc.dei.aor.paj.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pt.uc.dei.aor.paj.Music;

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

}
