package pt.uc.dei.aor.paj;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pt.uc.dei.aor.paj.Music;

@Named
@RequestScoped
public class MusicBean {

	private List <Music> musics;
	private Music newMusic;
	
	public MusicBean() {
		this.musics = new ArrayList<>();
		this.newMusic = new Music();
	}
	
	public void addMusic(){
		this.musics.add(this.newMusic);
		this.newMusic=new Music();
	}

	public List<Music> getMusics() {
		return musics;
	}

	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}

	public Music getNewMusic() {
		return newMusic;
	}

	public void setNewMusic(Music newMusic) {
		this.newMusic = newMusic;
	}
	
	
	
	
}
