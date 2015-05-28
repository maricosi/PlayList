package pt.uc.dei.aor.paj.fachada;

import java.util.List;
import javax.ejb.Local;
import pt.uc.dei.aor.paj.Playlist;

@Local
public interface IntPlaylistFachada {
	public abstract void save(Playlist playlist);

	public abstract Playlist update(Playlist playlist);

	public abstract void delete(Playlist playlist);

	public abstract Playlist find(int entityID);

	public abstract List<Playlist> findAll();
}
