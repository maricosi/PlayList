package pt.uc.dei.aor.paj;

import java.time.LocalDate;
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
	private int size;
	private String mensagem="";
	private Music musics;
	

	public PlaylistWeb() {
		super();
	}

	public List<Playlist> findAll(){
		return playlist.findAll();
	}
	
	public List<Playlist> findByUtilizador(){
		return playlist.findByUtilizador(login.getUsername());
	}
	
	public List<Playlist> orderByNameASC(){
		return playlist.orderByName(login.getUsername(),"ASC");
	}
	public List<Playlist> orderByNameDESC(){
		return playlist.orderByName(login.getUsername(),"DESC");
	}
	
	
	public List<Playlist> orderByDateASC(){
		return playlist.orderByDate(login.getUsername(), "ASC");
	}
	public List<Playlist> orderByDateDESC(){
		return playlist.orderByDate(login.getUsername(), "DESC");
	}
	
	public List<Playlist> orderBySizeASC(){
		return playlist.orderBySize(login.getUsername(), "ASC");
	}
	public List<Playlist> orderBySizeDESC(){
		return playlist.orderBySize(login.getUsername(), "DESC");
	}

	public void save(){
		this.mensagem=playlist.save(name, LocalDate.now(), login.getUsername() );
	}
	
	public void delete(){
		this.mensagem=playlist.delete(name,login.getUsername());
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	


}




