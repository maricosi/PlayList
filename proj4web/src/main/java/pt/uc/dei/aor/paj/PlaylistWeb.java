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
	private boolean editable;
		




	public PlaylistWeb() {
		super();
		
	}
	

	public List<Playlist> findAll(){
		return playlist.findAll();
	}
	
	public List<Playlist> getProcuraPlaylist(){
		if (procuraPlaylist==null){
			this.procuraPlaylist=playlist.orderByName(login.getUsername(),"ASC");
		}
		return procuraPlaylist;	
	}
	
	public void setProcuraPlaylist(List<Playlist> procuraPlaylist) {
		this.procuraPlaylist = procuraPlaylist;
	}
	
	public void findByUtilizador(){
		playlist.findByUtilizador(login.getUsername());
	}
	
	public void orderByNameASC(){
		setProcuraPlaylist(playlist.orderByName(login.getUsername(),"ASC"));
		
	}

	public void orderByNameDESC(){
		setProcuraPlaylist(playlist.orderByName(login.getUsername(),"DESC"));
		
	}
		
	public void orderByDateASC(){
		setProcuraPlaylist(playlist.orderByDate(login.getUsername(), "ASC"));
	}
	public void orderByDateDESC(){
		setProcuraPlaylist(playlist.orderByDate(login.getUsername(), "DESC"));
		
	}
	
	public void orderBySizeASC(){
		setProcuraPlaylist(playlist.orderBySize(login.getUsername(), "ASC"));
		
	}
				
	public void orderBySizeDESC(){
		setProcuraPlaylist(playlist.orderBySize(login.getUsername(), "DESC"));
	}

	public void save(){
		this.mensagem=playlist.save(name, LocalDate.now(), login.getUsername() );
	}
	
	public void delete(){
		this.mensagem=playlist.delete(name,login.getUsername());
	}
	
/*	public void update(){
		this.mensagem=playlist.update(name,login.getUsername());
	}*/
	
	
	public boolean isEditable() {
		return editable;
	}


	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	public String editAction(Playlist playlist) {
		setEditable(true);
		return null;
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




