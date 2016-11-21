package br.com.leandrorezende.marvel.web.model.character;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "character")
public class Character implements Serializable {

	private static final long serialVersionUID = 1L;

	protected  Character() {}

	public Character(Long id, String name, String description, Date modified) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.modified = modified;
	}

	@Id
	private Long id;

	private String name;

	@Lob
	@Column(length = 100000)
	private String description;

	private Date modified;

	private String resourceURI;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Url> urls;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "thumbnail_id")
	private Image thumbnail;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "comics_id")
	private ComicList comics;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stories_id")
	private StoryList stories;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "events_id")
	private EventList events;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "series_id")
	private SeriesList series;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModified() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		return sdf.format(modified);
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	public List<Url> getUrls() {
		return urls;
	}

	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}

	public Image getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
	}

	public ComicList getComics() {
		return comics;
	}

	public void setComics(ComicList comics) {
		this.comics = comics;
	}

	public StoryList getStories() {
		return stories;
	}

	public void setStories(StoryList stories) {
		this.stories = stories;
	}

	public EventList getEvents() {
		return events;
	}

	public void setEvents(EventList events) {
		this.events = events;
	}

	public SeriesList getSeries() {
		return series;
	}

	public void setSeries(SeriesList series) {
		this.series = series;
	}

}
