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
	private List<Playlist> procuraPlaylist;


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
		this.procuraPlaylist=playlist.orderByName(login.getUsername(),"ASC");
		return procuraPlaylist;
	}
	public List<Playlist> orderByNameDESC(){
		this.procuraPlaylist=playlist.orderByName(login.getUsername(),"DESC");
		return procuraPlaylist;
	}
		
	public List<Playlist> orderByDateASC(){
		this.procuraPlaylist=playlist.orderByDate(login.getUsername(), "ASC");
		return procuraPlaylist;
	}
	public List<Playlist> orderByDateDESC(){
		this.procuraPlaylist=playlist.orderByDate(login.getUsername(), "DESC");
		return procuraPlaylist;
	}
	
	public List<Playlist> orderBySizeASC(){
		this.procuraPlaylist=playlist.orderBySize(login.getUsername(), "ASC");
		return procuraPlaylist;
		
	}
				
	public List<Playlist> orderBySizeDESC(){
		this.procuraPlaylist=playlist.orderBySize(login.getUsername(), "DESC");
		return procuraPlaylist;
	}

	public void save(){
		this.mensagem=playlist.save(name, LocalDate.now(), login.getUsername() );
	}
	
	public void delete(){
		this.mensagem=playlist.delete(name,login.getUsername());
	}
	
	/*public void update(){
		this.mensagem=playlist.update(name,login.getUsername());
	}*/

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
	public List<Playlist> getProcuraPlaylist() {
		return procuraPlaylist;
	}

	public void setProcuraPlaylist(List<Playlist> procuraPlaylist) {
		this.procuraPlaylist = procuraPlaylist;
	}

	
	


}




