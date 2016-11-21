package br.com.leandrorezende.marvel.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.leandrorezende.marvel.web.model.character.Character;

public interface CharacterRepository extends CrudRepository<Character, Long> {
	List<Character> findByName(String name);
	
}
