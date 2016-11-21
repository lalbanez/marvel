package br.com.leandrorezende.marvel.web.model.character;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "event_list")
public class EventList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int available;

	private int returned;

	private String collectionULR;

	@OneToMany(mappedBy="eventList")
	private List<EventSummary> items;

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

	public String getCollectionULR() {
		return collectionULR;
	}

	public void setCollectionULR(String collectionULR) {
		this.collectionULR = collectionULR;
	}

	public List<EventSummary> getItems() {
		return items;
	}

	public void setItems(List<EventSummary> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		EventList other = (EventList) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
