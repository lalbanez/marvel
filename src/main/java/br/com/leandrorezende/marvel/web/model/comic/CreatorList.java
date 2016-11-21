package br.com.leandrorezende.marvel.web.model.comic;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "creator_list")
public class CreatorList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int available;

	private int returned;

	private String collectionURI;

	@OneToMany(mappedBy = "creatorList")
	private List<CreatorSummary> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getReturned() {
		return returned;
	}

	public void setReturned(int returned) {
		this.returned = returned;
	}

	public String getCollectionURI() {
		return collectionURI;
	}

	public void setCollectionURI(String collectionURI) {
		this.collectionURI = collectionURI;
	}

	public List<CreatorSummary> getItems() {
		return items;
	}

	public void setItems(List<CreatorSummary> items) {
		this.items = items;
	}

}
