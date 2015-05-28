package pt.uc.dei.aor.paj.fachada;

import java.util.List;
import javax.ejb.Local;
import pt.uc.dei.aor.paj.User;

@Local
public interface IntUserFachada {
	public abstract void save(User user);

	public abstract User update(User user);

	public abstract void delete(User user);

	public abstract User find(int entityID);

	public abstract List<User> findAll();
}
