package pt.uc.dei.aor.paj.fachada;


import javax.ejb.Local;

import pt.uc.dei.aor.paj.Utilizador;

@Local
public interface IntUserFachada {
	public abstract String save(String name, String username, String email , String password);

	public abstract String update(Utilizador utilizador, String usernameVelho, String emailVelho);

	public abstract String delete(Utilizador utilizador);

	public abstract Utilizador find(String username, String password);

	public abstract String validate(String username, String password);
	
	public String nameUser(String username, String password);
	
	public String emailUser(String username, String password);

	
}
