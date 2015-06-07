package pt.uc.dei.aor.paj;


import java.time.LocalDate;
import java.util.List;






import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "Playlist")
@NamedQueries({
		@NamedQuery(name = "Playlist.findAll", query="SELECT p FROM Playlist p"),
		@NamedQuery(name = "Playlist.utilizadorOrderByNameASC", query="SELECT p FROM Playlist p WHERE p.utilizador=:utilizador ORDER BY p.name ASC"),
		@NamedQuery(name = "Playlist.utilizadorOrderByNameDESC", query="SELECT p FROM Playlist p WHERE p.utilizador=:utilizador  ORDER BY p.name DESC"),
		@NamedQuery(name = "Playlist.utilizadorOrderByDateASC", query="SELECT p FROM Playlist p WHERE p.utilizador=:utilizador ORDER BY p.date ASC"),
		@NamedQuery(name = "Playlist.utilizadorOrderByDateDESC", query="SELECT p FROM Playlist p WHERE p.utilizador=:utilizador ORDER BY p.date DESC"),
		@NamedQuery(name = "Playlist.utilizadorOrderBySizeASC", query="SELECT p FROM Playlist p WHERE p.utilizador=:utilizador ORDER BY p.date ASC"),
		@NamedQuery(name = "Playlist.utilizadorOrderBySizeDESC", query="SELECT p FROM Playlist p WHERE p.utilizador=:utilizador ORDER BY p.size DESC"),
		@NamedQuery(name = "Playlist.findByNameUtilizador", query="SELECT p FROM Playlist p  WHERE p.name=:name and p.utilizador=:utilizador"),
		@NamedQuery(name = "Playlist.findByUtilizador", query="SELECT p FROM Playlist p  WHERE p.utilizador=:utilizador"),
		@NamedQuery(name = "Playlist.findMusicsByPlaylist", query="SELECT m FROM Playlist p  join p.musics m where p.id=:id"),

		
})

public class Playlist{
	
	public static final String FIND_ALL = "Playlist.findAll";
	public static final String ORDER_BY_NAME_ASC = "Playlist.utilizadorOrderByNameASC";
	public static final String ORDER_BY_NAME_DESC = "Playlist.utilizadorOrderByNameDESC";
	public static final String ORDER_BY_DATE_ASC = "Playlist.utilizadorOrderByDateASC";
	public static final String ORDER_BY_DATE_DESC = "Playlist.utilizadorOrderByDateDESC";
	public static final String ORDER_BY_SIZE_ASC = "Playlist.utilizadorOrderBySizeASC";
	public static final String ORDER_BY_SIZE_DESC = "Playlist.utilizadorOrderBySizeDESC";
	public static final String FIND_BY_NAME_UTILIZADOR = "Playlist.findByNameUtilizador";
	public static final String FIND_BY_UTILIZADOR = "Playlist.findByUtilizador";
	public static final String FIND_MUSICS_BY_PLAYLIST = "Playlist.findMusicsByPlaylist";
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	@Column (name="name", nullable=false, length=25)	
	private String name;	

	
	@Column (name="date", nullable=false, length=50)
	private LocalDate date;	
	@Column (name="size", length=10)
	private int size;	
	@ManyToMany (fetch=FetchType.EAGER)
	private List<Music> musics;
	@ManyToOne
	private Utilizador utilizador;
	@Transient
	private boolean editable= false;


	public Playlist(){		
	}

	public Playlist(String name, LocalDate date, Utilizador utilizador) {

		super();
		this.name = name;
		this.date = date;
		this.utilizador=utilizador;
	}
	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
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


	public int getSize() {
		return size;
	}

	public void setSize() {
		this.size = musics.size();
	}

	public List<Music> getMusics() {
		return musics;
	}

	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}

	public Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}
	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {

		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((musics == null) ? 0 : musics.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + size;
		result = prime * result
				+ ((utilizador == null) ? 0 : utilizador.hashCode());
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
		if (musics == null) {
			if (other.musics != null)
				return false;
		} else if (!musics.equals(other.musics))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (size != other.size)
			return false;
		if (utilizador == null) {
			if (other.utilizador != null)
				return false;
		} else if (!utilizador.equals(other.utilizador))
			return false;
		return true;
	}

	public String toString() {
		return  name;
	}

}