package br.com.leandrorezende.marvel.web.model.comic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="creator_summary")
public class CreatorSummary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String resourceURI;

	private String name;

	private String role;

	@ManyToOne
	@JoinColumn(name = "creatorList_id")
	private CreatorList creatorList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CreatorList getCreatorList() {
		return creatorList;
	}

	public void setCreatorList(CreatorList creatorList) {
		this.creatorList = creatorList;
	}

}
