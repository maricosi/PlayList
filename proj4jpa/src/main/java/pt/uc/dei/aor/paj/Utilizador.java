package pt.uc.dei.aor.paj;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "User.findByUsernamePass", 
			query = "SELECT u FROM Utilizador u WHERE u.username like :username AND u.password like :password"),
	@NamedQuery(name = "User.findByUsername", query="SELECT u FROM Utilizador u WHERE u.username like :username"),
	@NamedQuery(name = "User.findByEmail", query="SELECT u FROM Utilizador u WHERE u.email like :email")})



public class Utilizador{
	
	public static final String FIND_BY_USERNAME_PASS = "User.findByUsernamePass";
	public static final String FIND_BY_USERNAME = "User.findByUsername";
	public static final String FIND_BY_EMAIL = "User.findByEmail";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "name", nullable = false, length = 25)
	private String name;
	@Column(name = "username", nullable = false, length = 15, unique = true)
	private String username;	
	@Column(name = "email", nullable = false, length = 50, unique = true)	
	private String email;
	@Column(name = "password", nullable = false)
	private String password;
	@OneToMany(mappedBy = "utilizador")
	private List<Playlist> playlist;
	@OneToMany(mappedBy = "utilizador")
	private List<Music> musics;

	public Utilizador() {
		super();
	}

	public Utilizador(String name, String email, String username, String password) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Playlist> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<Playlist> playlist) {
		this.playlist = playlist;
	}

	public List<Music> getMusics() {
		return musics;
	}

	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}

	public boolean isLogged(){
		return name !=null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilizador other = (Utilizador) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public String toString() {
		return name + "";
	}

}

