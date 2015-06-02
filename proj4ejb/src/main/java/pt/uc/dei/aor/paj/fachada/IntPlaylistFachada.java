package pt.uc.dei.aor.paj.fachada;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import pt.uc.dei.aor.paj.Playlist;
import pt.uc.dei.aor.paj.User;

@Local
public interface IntPlaylistFachada {

	public abstract Playlist update(Playlist playlist);

	public abstract void delete(Playlist playlist);

	public abstract Playlist find(int entityID);

	public abstract List<Playlist> findAll();

	public abstract String save(String name, Date date, String username);
}
