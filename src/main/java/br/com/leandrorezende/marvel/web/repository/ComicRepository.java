package br.com.leandrorezende.marvel.web.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.leandrorezende.marvel.web.model.comic.Comic;

public interface ComicRepository extends CrudRepository<Comic, Long>{
}
