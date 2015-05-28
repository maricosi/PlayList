package pt.uc.dei.aor.paj.DAO;

import java.util.List;

import javax.ejb.Stateless;

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

	public List<Music> all(){
		return em.createQuery("from Music t", Music.class).getResultList();
	}

}
