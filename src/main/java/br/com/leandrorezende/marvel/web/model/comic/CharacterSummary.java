package br.com.leandrorezende.marvel.web.model.comic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="character_summary")
public class CharacterSummary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String resourceURI;

	private String name;

	private String role;

	@ManyToOne
	@JoinColumn(name = "characterList_id")
	private CharacterList characterList;

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

	public CharacterList getCharacterList() {
		return characterList;
	}

	public void setCharacterList(CharacterList characterList) {
		this.characterList = characterList;
	}

}
