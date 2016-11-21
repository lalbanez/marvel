package br.com.leandrorezende.marvel.web.model.comic;

import java.io.Serializable;
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

import br.com.leandrorezende.marvel.web.model.character.ComicSummary;
import br.com.leandrorezende.marvel.web.model.character.EventList;
import br.com.leandrorezende.marvel.web.model.character.Image;
import br.com.leandrorezende.marvel.web.model.character.SeriesSummary;
import br.com.leandrorezende.marvel.web.model.character.StoryList;
import br.com.leandrorezende.marvel.web.model.character.Url;

@Entity
@Table(name = "comic")
public class Comic implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Comic() {
	}

	@Id
	private Long id;

	private Long digitalId;

	private String title;

	private double issueNumber;

	@Lob
	@Column(length = 100000)
	private String variantDescription;

	@Lob
	@Column(length = 100000)
	private String description;

	private Date modified;

	private String isbn;

	private String upc;

	private String diamontCode;

	private String ean;

	private String issn;

	private String format;

	private int pageCount;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TextObject> textObjects;

	private String resourceURI;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Url> urls;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "series_id")
	private SeriesSummary series;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ComicSummary> variants;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ComicSummary> collections;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ComicSummary> collectedIssues;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ComicDate> dates;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ComicPrice> prices;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "thumbnail_id")
	private Image thumbnail;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Image> images;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "creators_id")
	private CreatorList creators;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "characters_id")
	private CharacterList characters;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stories_id")
	private StoryList stories;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "events_id")
	private EventList events;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDigitalId() {
		return digitalId;
	}

	public void setDigitalId(Long digitalId) {
		this.digitalId = digitalId;
	}

	public double getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(double issueNumber) {
		this.issueNumber = issueNumber;
	}

	public String getVariantDescription() {
		return variantDescription;
	}

	public void setVariantDescription(String variantDescription) {
		this.variantDescription = variantDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getDiamontCode() {
		return diamontCode;
	}

	public void setDiamontCode(String diamontCode) {
		this.diamontCode = diamontCode;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<TextObject> getTextObjects() {
		return textObjects;
	}

	public void setTextObjects(List<TextObject> textObjects) {
		this.textObjects = textObjects;
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

	public SeriesSummary getSeries() {
		return series;
	}

	public void setSeries(SeriesSummary series) {
		this.series = series;
	}

	public List<ComicSummary> getVariants() {
		return variants;
	}

	public void setVariants(List<ComicSummary> variants) {
		this.variants = variants;
	}

	public List<ComicSummary> getCollections() {
		return collections;
	}

	public void setCollections(List<ComicSummary> collections) {
		this.collections = collections;
	}

	public List<ComicSummary> getCollectedIssues() {
		return collectedIssues;
	}

	public void setCollectedIssues(List<ComicSummary> collectedIssues) {
		this.collectedIssues = collectedIssues;
	}

	public List<ComicDate> getDates() {
		return dates;
	}

	public void setDates(List<ComicDate> dates) {
		this.dates = dates;
	}

	public List<ComicPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<ComicPrice> prices) {
		this.prices = prices;
	}

	public Image getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public CreatorList getCreators() {
		return creators;
	}

	public void setCreators(CreatorList creators) {
		this.creators = creators;
	}

	public CharacterList getCharacters() {
		return characters;
	}

	public void setCharacters(CharacterList characters) {
		this.characters = characters;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
