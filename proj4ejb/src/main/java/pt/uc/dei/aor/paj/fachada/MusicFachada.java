package pt.uc.dei.aor.paj.fachada;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;





import pt.uc.dei.aor.paj.Music;
import pt.uc.dei.aor.paj.User;
import pt.uc.dei.aor.paj.DAO.MusicDAO;


@Stateless
public class MusicFachada implements IntMusicFachada{

	@EJB
	private MusicDAO musicDAO;

	public String save(String title, String artist, String album, String url, int year, User user) {
		Music music =new Music(artist,title,album,year,url,null);
		try{
			isMusicWithAllData(music);
			musicDAO.save(music);
			return "Musica criada com sucesso";
		} catch (IllegalArgumentException e){
			return e.getMessage();
		}
		
		
	}


/*	@Override
	public Music update(Music music) {
		isMusicWithAllData(music);
		return musicDAO.update(music);
	}*/

	@Override
	public void delete(Music music) {
		// TODO Auto-generated method stub

	}

/*	@Override
	public Music find(int entityID) {
		
		return return musicDAO.find(entityID);
	}*/

	@Override
	public List<Music> findAll() {	
		return musicDAO.all();
	}


	/*	public Music update(Music music) {
		isDogWithAllData(music);

		return musicDAO.update(music);
	}


	public void delete(Music music) {
		musicDAO.delete(music);
	}


	public Music find(int entityID) {
		return musicDAO.find(entityID);
	}


	public List<Music> findAll() {
		return musicDAO.findAll();
	}
	 */

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
	public Music update(Music music) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Music find(int entityID) {
		// TODO Auto-generated method stub
		return null;
	}


	
}

