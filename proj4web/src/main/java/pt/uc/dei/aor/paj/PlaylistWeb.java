package pt.uc.dei.aor.paj;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pt.uc.dei.aor.paj.fachada.IntPlaylistFachada;

@Named
@RequestScoped
public class PlaylistWeb {

	@EJB
	private IntPlaylistFachada playlist;
	@Inject
	private Login login;
	private String name;
	private String date;
	private int size;
	private String mensagem="";
	private Music musics;

	public PlaylistWeb() {
		super();
	}

	public List<Playlist> findAll(){
		return playlist.findAll();
	}

	public void save(){
		this.mensagem=playlist.save(name, date, login.getUsername() );
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate() {
		Date hora = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
		this.date=formatador.format(hora)+"";
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	


}




