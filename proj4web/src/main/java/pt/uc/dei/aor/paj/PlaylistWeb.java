package pt.uc.dei.aor.paj;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pt.uc.dei.aor.paj.fachada.IntPlaylistFachada;

@Named
@RequestScoped
public class PlaylistWeb {
	@EJB
	private IntPlaylistFachada playlist;
	private String name;
	private Date date;
	private int size;
	private String mensagem="";
	private User user;
	private Music musics;



	public PlaylistWeb() {
		super();
	}

	public List<Playlist> findAll(){
		return playlist.findAll();
	}

	public void save(){
		this.mensagem=playlist.save(name, date, user);
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Music getMusics() {
		return musics;
	}

	public void setMusics(Music musics) {
		this.musics = musics;
	}

	public IntPlaylistFachada getPlaylist() {
		return playlist;
	}

	public void setPlaylist(IntPlaylistFachada playlist) {
		this.playlist = playlist;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}




