package pt.uc.dei.aor.paj.fachada;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.paj.Music;
import pt.uc.dei.aor.paj.Utilizador;
import pt.uc.dei.aor.paj.DAO.MusicDAO;
import pt.uc.dei.aor.paj.DAO.UserDAO;


@Stateless
public class MusicFachada implements IntMusicFachada{

	@EJB
	private MusicDAO musicDAO;
	@EJB
	private UserDAO userDAO;
	private static final Logger logger = LoggerFactory.getLogger(MusicFachada.class);

	
	@Override
	public Music find(int entityID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Music music) {
		musicDAO.delete(music.getId(), Music.class);
	}
	
	

	@Override
	public String update(Music music) {
	
		
		try{
		musicDAO.update(music);
		return "Musica alterada com sucesso!!!";
		}catch (IllegalArgumentException e){
			logger.error( e.getMessage());
			return "Ocorreu um erro no sistema!!!";
		}
	}


	@Override
	public List<Music> findAll() {	
		return musicDAO.all();
	}

	public String save(String title, String artist, String album, String url, int year, String username) {
		Utilizador utilizador=userDAO.findUsername(username).get(0);
		Music music =new Music(artist,title,album,year,url,utilizador);
		try{
			isMusicWithAllData(music);
			musicDAO.save(music);
			return "Musica criada com sucesso";
		}catch (IllegalArgumentException e){
			logger.error( e.getMessage());
			return "Ocorreu um erro no sistema!!!";
		}
	}


	private boolean isMusicWithAllData(Music music){
		boolean hasError = false;
		String mensagemErro="";

		if(music == null){
			hasError = true;
		}
		System.out.println(music);
		if (music.getTitle() == null || "".equals(music.getTitle().trim())){
			hasError = true;
			mensagemErro=mensagemErro+"Título ";
		}

		if(music.getUrl()== null || "".equals(music.getUrl().trim())){
			hasError = true;
			mensagemErro=mensagemErro+"Url ";
		}

		if(Integer.toString(music.getYear()).length()!=4){
			hasError = true;
			mensagemErro=mensagemErro+"Ano ";
		}

		if(music.getArtist() == null || "".equals(music.getArtist().trim())){
			hasError = true;
			mensagemErro=mensagemErro+"Artista ";
		}

		if(music.getAlbum()== null || "".equals(music.getAlbum().trim())){
			hasError = true;
			mensagemErro=mensagemErro+"Album ";
		}

		if (hasError){
			throw new IllegalArgumentException("Prencha o(s) campo(s): " + mensagemErro + "!!!");
		}

		return !hasError;
	}

	@Override
	public List<Music> findAllByTitleArtist(String title, String artist) {
		return musicDAO.findByTitleArtist(title, artist);
	}


	
	public List<Music> findAllByUtilizador(String username) {
		return musicDAO.findByUtilizador(username);
	}
	
	public String idMusicsUtilizadorNull(Utilizador utilizador) {
		try{
		List<Music> musicUtilizador=findAllByUtilizador(utilizador.getUsername());
		musicDAO.idMusicsUtilizadorNull(musicUtilizador);
		return "As musicas já não lhe pertencem!!!";
		}catch (IllegalArgumentException e){
			logger.error( e.getMessage());
			return "Ocorreu um erro no sistema!!!";
		}
	}

	public String idMusicUtilizadorNull( Music m) {
		
		try{
		musicDAO.idMusicUtilizadorNull(m);
		return "A musica com titulo, "+m.getTitle()+", já não lhe pertence!!!";
		}catch (IllegalArgumentException e){
			logger.error( e.getMessage());
			return "Ocorreu um erro no sistema!!!";
		}
	}






}

