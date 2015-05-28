package pt.uc.dei.aor.paj;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;

import pt.uc.dei.aor.paj.fachada.IntMusicFachada;
import pt.uc.dei.aor.paj.fachada.MusicFachada;

@Named
@RequestScoped
public class MusicWeb {
	@EJB
	private IntMusicFachada music;
	

	private String artist;
	private String title;
	private String album;
	private int year;
	private String path;
	private String messagem="";

	public MusicWeb() {
		super();
	}
	
	public List<Music> findAll (){
		return music.findAll();
	}
	
	public void save (){
		this.messagem=music.save(title, artist, album, path, year);
	}
	public String getMessagem() {
		return messagem;
	}

	public void setMessagem(String messagem) {
		this.messagem = messagem;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}




}
