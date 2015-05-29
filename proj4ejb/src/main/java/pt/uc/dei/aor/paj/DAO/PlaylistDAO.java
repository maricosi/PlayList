package pt.uc.dei.aor.paj.DAO;

import pt.uc.dei.aor.paj.Playlist;

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


}
