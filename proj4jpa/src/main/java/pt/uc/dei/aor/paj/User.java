package pt.uc.dei.aor.paj;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Player
 *
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

	private static final long serialVersionUID = 6489766761681319838L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name", nullable = false, length = 25)
	private String name;
	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;
	@Column(name = "password", nullable = false, length = 20)
	private String password;
	@OneToMany(mappedBy="user")
	private List<Playlist> myPlaylist;
	@OneToMany(mappedBy="user")
	private List<Music> myMusics;


	public User() {
		// TODO Auto-generated constructor stub
	}


	public List<Music> getMyMusics() {
		return myMusics;
	}

	public void setMyMusics(List<Music> myMusics) {
		this.myMusics = myMusics;
	}


	public boolean isLogged(){
		return name !=null;
	}
	//	
	//	public boolean isOwner(){
	//		return 
	//	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		return myPlaylist;
	}

	public void setPlaylist(List<Playlist> playlist) {
		this.myPlaylist = playlist;
	}


	public List<Playlist> getMyPlaylist() {
		return myPlaylist;
	}

	public void setMyPlaylist(List<Playlist> myPlaylist) {
		this.myPlaylist = myPlaylist;
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
		User other = (User) obj;
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
		return "";
	}

}
