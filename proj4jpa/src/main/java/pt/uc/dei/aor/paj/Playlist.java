package pt.uc.dei.aor.paj;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Playlist")
@NamedQueries({
		@NamedQuery(name = "Playlist.findAll", query="SELECT p FROM Playlist p"),
		@NamedQuery(name = "Playlist.findByNameASC", query="SELECT p FROM Playlist p ORDER BY p.name ASC"),
		@NamedQuery(name = "Playlist.findByNameDESC", query="SELECT p FROM Playlist p ORDER BY p.name DESC"),
		@NamedQuery(name = "Playlist.findByDateASC", query="SELECT p FROM Playlist p ORDER BY p.date ASC"),
		@NamedQuery(name = "Playlist.findByDateDESC", query="SELECT p FROM Playlist p ORDER BY p.date DESC"),
		@NamedQuery(name = "Playlist.findBySizeASC", query="SELECT p FROM Playlist p ORDER BY p.date ASC"),
		@NamedQuery(name = "Playlist.findBySizeDESC", query="SELECT p FROM Playlist p ORDER BY p.size DESC"),
})

public class Playlist{
	
	public static final String FIND_ALL = "Playlist.findAll";
	public static final String FIND_BY_NAME_ASC = "Playlist.findByNameASC";
	public static final String FIND_BY_NAME_DESC = "Playlist.findByNameDESC";
	public static final String FIND_BY_DATE_ASC = "Playlist.findByDateASC";
	public static final String FIND_BY_DATE_DESC = "Playlist.findByDateDESC";
	public static final String FIND_BY_SIZE_ASC = "Playlist.findBySizeASC";
	public static final String FIND_BY_SIZE_DESC = "Playlist.findBySizeDESC";

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	@Column (name="name", nullable=false, length=25)	
	private String name;	
	@Temporal(TemporalType.DATE)
	@Column (name="date", nullable=false, length=50)
	private Date date;	
	@Column (name="size", nullable=false, length=10)
	private int size;	
	@ManyToMany
	private List<Music> musics;
	@ManyToOne
	private User user;
	
	public Playlist(){		
	}

	public Playlist(String name, Date date, User user) {
		super();
		this.name = name;
		this.date = date;
		this.user=user;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Music> getMusics() {
		return musics;
	}

	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
//    public String noSongs(){
//        return ""+musics.size();
//    }
 

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Playlist other = (Playlist) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString() {
		return  name+ " / " + date;
	}

}