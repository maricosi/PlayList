package pt.uc.dei.aor.paj;

import pt.uc.dei.aor.paj.Playlist;

public class PlaylistDAO extends GenericDAO<Playlist>{

	public PlaylistDAO() {
		super(Playlist.class);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 4712656372734128260L;
	
	
	
	
	public void deletePlaylist (Playlist playlist){
		super.delete(playlist.getId(), Playlist.class);
	}
	
//	public void updatePlaylist (Playlist playlist){
//		super.merge(playlist.getId(), Playlist.class); 		
//	}
//	
	
}
