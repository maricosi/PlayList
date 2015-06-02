package pt.uc.dei.aor.paj.fachada;


import java.time.LocalDate;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import pt.uc.dei.aor.paj.Playlist;
import pt.uc.dei.aor.paj.User;
import pt.uc.dei.aor.paj.DAO.PlaylistDAO;
import pt.uc.dei.aor.paj.DAO.UserDAO;


@Stateless
public class PlaylistFachada implements IntPlaylistFachada{

	@EJB
	private PlaylistDAO playlistDAO;
	@EJB
	private UserDAO userDAO;

	public String save(String name, LocalDate date, String username) {
		User user=userDAO.findUsername(username).get(0);
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


	public String delete(String name, String username) {
		String mensagem="";
		User user=userDAO.findUsername(name).get(0);
		List<Playlist> playlist=playlistDAO.findNameUser(name, user);
		if(playlist.size()==0){
			mensagem= "Playlist inexistente!!!";
		} else if (playlist.size()==1){
			int id= playlist.get(0).getId();
			playlistDAO.delete(id,Playlist.class);
			mensagem="Playlist,"+playlist.get(0).getName()+ "apagada com sucesso!!!";
		}
		return mensagem;
	}





	@Override
	public Playlist update(Playlist playlist) {
		// TODO Auto-generated method stub
		return null;
	}

	//	@Override
	//	public void delete(Playlist playlist) {
	//		// TODO Auto-generated method stub		
	//	}


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







