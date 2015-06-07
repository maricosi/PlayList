package pt.uc.dei.aor.paj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.uc.dei.aor.paj.fachada.IntMusicFachada;
import pt.uc.dei.aor.paj.fachada.IntPlaylistFachada;

@Named
@ViewScoped
public class MusicWeb implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
	private IntMusicFachada music;
	@EJB
	private IntPlaylistFachada play;
	@Inject
	private Login login;
	@Inject
	private PlaylistWeb playlistWeb;
	@Inject
	private UploadFile upload;
	private String currentURL;
	private String artist;
	private String title;
	private String album;
	private int year;
	private String url;
	private String mensagem="";
	private String mensagem2="";
	private List<Music> procuraMusic;
	private ArrayList<Music> musicaTrue=new ArrayList<Music>();
	private List<Music>minhaMusic;
	private String nameplaylist;
	private List<Playlist> playlist;
	private  boolean table = false;
	private static final Logger logger = LoggerFactory.getLogger(MusicWeb.class);


	public MusicWeb() {
		super();
	}

	public Part getFile() {
		return upload.getFile();
	}

	public void setFile(Part file) {
		upload.setFile(file);
	}

	public String getCurrentURL() {
		return currentURL;
	}

	public void setCurrentURL(String currentURL) {
		this.currentURL = currentURL;
	}
	public List<Music> findAll(){
		return music.findAll();
	}

	public void adicionarMusica(){
		int i = 0;
		for(Music m:procuraMusic){
			if(m.isCheck()==true){
				musicaTrue.add(m);
				i++;
			}
		}
		logger.info("Tamanho da lista:" + musicaTrue.size() + "numero de Musicas a true: " + i );
		for(Playlist p:playlist){
			if(nameplaylist.equals(p.getName())){
				this.mensagem2=play.adicionarMusic(musicaTrue,p);
			}
		}
		musicaTrue.clear();
	}

	public List<Playlist> getPlaylist() {
		if(playlist==null){
			this.playlist=playlistWeb.getProcuraPlaylist();
		}
		return playlist;
	}

	public void setPlaylist(List<Playlist> playlist) {
		this.playlist = playlist;
	}


	public void save(){
		upload.upload();
		this.url=upload.getPath();
		this.mensagem=music.save(title, artist, album, url, year, login.getUsername());
		this.album=this.artist=this.title=this.url="";
		this.year=0;
	}

	public void findByTitleArtist (){
		this.procuraMusic=music.findAllByTitleArtist(title, artist);
		if(procuraMusic.size()==0){
			this.mensagem="Critério(s) de procura sem resultados";
		}
	}




	public List<Music> findAllByUtilizador(){
		this.minhaMusic=music.findAllByUtilizador(login.getUsername());
		return minhaMusic;
	}

	public void editAction(Music music) {
		music.setEditable(true);
	}

	public void update(Music m) {
		logger.info("antes"+m.getTitle());
		music.update(m);
		logger.info("depois"+m.getTitle());
		findAllByUtilizador();
	}

	public void idMusicUtilizadorNull (Music m){
		music.idMusicUtilizadorNull(m);
		findAllByUtilizador();
		this.mensagem2="";
	}


	

	public List<Music> getProcuraMusic() {
		return procuraMusic;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isTable() {
		return table;
	}

	public void setTable(boolean table) {
		this.table = table;
	}

	public void showTable(){
		this.table=true;
	}

	public String getMensagem2() {
		return mensagem2;
	}

	public void setMensagem2(String mensagem2) {
		this.mensagem2 = mensagem2;
	}

	public String getNameplaylist() {
		return nameplaylist;
	}

	public void setNameplaylist(String nameplaylist) {
		this.nameplaylist = nameplaylist;
	}

	public void playMusic(Music music){
		this.currentURL=music.getUrl();
	}

	public List<Music> getMinhaMusic() {
		if (minhaMusic==null){
			this.minhaMusic=findAllByUtilizador();
		}
		return minhaMusic;
	}

	public void setMinhaMusic(List<Music> minhaMusic) {
		this.minhaMusic = minhaMusic;
	}
}
