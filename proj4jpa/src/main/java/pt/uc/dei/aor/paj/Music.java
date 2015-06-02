package pt.uc.dei.aor.paj;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Music.findAll", query="SELECT m FROM Music m"),
	@NamedQuery(name = "Music.findByArtist", query="SELECT m FROM Music m WHERE m.artist like :artist"),
	@NamedQuery(name = "Music.findByTitle", query="SELECT m FROM Music m WHERE m.title like :title"),
	@NamedQuery(name = "Music.findByAlbum", query="SELECT m FROM Music m WHERE m.album like :album"),
	@NamedQuery(name = "Music.findByYear", query="SELECT m FROM Music m WHERE m.year like :year"),
	@NamedQuery(name = "Music.findByUtilizador", query="SELECT m FROM Music m WHERE m.utilizador like :utilizador"),
	@NamedQuery(name = "Music.findByTitleArtist", query="SELECT m FROM Music m WHERE m.title like :title and m.artist like :artist"),
})

public class Music{
	
	public static final String FIND_ALL = "Music.findAll";
	public static final String FIND_BY_ARTIST = "Music.findByArtist";
	public static final String FIND_BY_TITLE = "Music.findByTitle";
	public static final String FIND_BY_ALBUM = "Music.findByAlbum";
	public static final String FIND_BY_YEAR = "Music.findByYear";
	public static final String FIND_BY_UTILIZADOR = "Music.findByUtilizador";
	public static final String FIND_BY_TITLE_ARTIST = "Music.findByTitleArtist";
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	@Column (name="artist", nullable=false, length=20)
	private String artist;	
	@Column (name="title", nullable=false, length=30)
	private String title;	
	@Column (name="album", nullable=false, length=30)
	private String album;
	@Column (name="year", nullable=false, length=10)
	private int year;	
	@Column (name="url", nullable=false, length=80)
	private String url;
	@ManyToOne
    private Utilizador utilizador;
	
	public Music() {
		super();
	}
	
	public Music(String artist, String title, String album, int year, String url, Utilizador utilizador ) {
		super();
		this.artist = artist;
		this.title = title;
		this.album=album;
		this.year = year;
		this.url = url;
		this.utilizador=utilizador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
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
		Music other = (Music) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	public String toString() {
		return artist + " / " + title + " / " + " / " + album + " / " + year + " / " + url ;
	}
	
}