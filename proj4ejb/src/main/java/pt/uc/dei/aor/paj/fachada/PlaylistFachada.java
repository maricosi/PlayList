package pt.uc.dei.aor.paj.fachada;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import pt.uc.dei.aor.paj.Music;
import pt.uc.dei.aor.paj.Playlist;
import pt.uc.dei.aor.paj.User;
import pt.uc.dei.aor.paj.DAO.MusicDAO;
import pt.uc.dei.aor.paj.DAO.PlaylistDAO;

public class PlaylistFachada implements IntPlaylistFachada{
	@EJB
	private PlaylistDAO playlistDAO;


	public String save(String name, Date date, User user) {
		Playlist playlist =new Playlist(name,date,user);
		try{
			isPlaylistWithAllData(playlist);
			playlistDAO.save(playlist);
			return "Playlist criada com sucesso";
		} catch (IllegalArgumentException e){
			return e.getMessage();
		}
	}


	private boolean isPlaylistWithAllData(Playlist playlist){
		boolean hasError = false;
		String mensagemErro="";

		if(playlist == null){
			hasError = true;
		}
		
		if (playlist.getName() == null || "".equals(playlist.getName().trim())){
			hasError = true;
			mensagemErro=mensagemErro+"Nome ";
		}

		if(playlist.getDate()== null){
			hasError = true;
			mensagemErro=mensagemErro+"Date ";
		}

		if (hasError){
			throw new IllegalArgumentException("Prencha o(s) campo(s): " + mensagemErro + "!!!");
		}

		return !hasError;
	}

	@Override
	public Playlist update(Playlist playlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Playlist playlist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Playlist find(int entityID) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Playlist> findAll() {
		// TODO Auto-generated method stub
		return null;
	}






}

	
	
	



