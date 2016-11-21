package br.com.leandrorezende.marvel.web.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import br.com.leandrorezende.marvel.web.model.character.CharacterDataWrapper;
import br.com.leandrorezende.marvel.web.model.character.Conexao;
import br.com.leandrorezende.marvel.web.model.comic.Comic;
import br.com.leandrorezende.marvel.web.model.comic.ComicDataWrapper;
import br.com.leandrorezende.marvel.web.repository.CharacterRepository;
import br.com.leandrorezende.marvel.web.repository.ComicRepository;
import br.com.leandrorezende.marvel.web.util.Utils;

@Repository
public class ConexaoService {

	public static Conexao con;

	@Autowired
	public CharacterRepository characterRepository;
	
	@Autowired
	public ComicRepository comicRepository;

	public void getCharacters() {
		Collection<CharacterDataWrapper> list = new ArrayList<CharacterDataWrapper>();
		CharacterDataWrapper characterDataWrapper = new CharacterDataWrapper();
	do {
		con.setTimestamp(String.valueOf(System.currentTimeMillis()));
		con.setMd5(Utils.toMd5(con.getTimestamp() + con.getPrivateKey() + con.getPublicKey()));
		con.setLimit(100);
		Gson gson = new Gson();
		Client c = Client.create();
		WebResource wr = c.resource("http://gateway.marvel.com/v1/public/characters?ts=" + con.getTimestamp()
				+ "&apikey=" + con.getPublicKey() + "&hash=" + con.getMd5() + "&limit=" + con.getLimit() + "&offset="
				+ con.getOffset());
		try {
			String jstring = "[" + wr.get(String.class) + "]";
			Type collectionType = new TypeToken<Collection<CharacterDataWrapper>>() {
			}.getType();
			list = gson.fromJson(jstring, collectionType);
			for (Iterator<CharacterDataWrapper> iterator = list.iterator(); iterator.hasNext();) {
				characterDataWrapper = (CharacterDataWrapper) iterator.next();
				for (int i = 0; i < characterDataWrapper.getData().getResults().length; i++) {
					characterRepository.save(characterDataWrapper.getData().getResults()[i]);
				}
			}
			if (con.getOffset() + 100 > characterDataWrapper.getData().getTotal()) {
				con.setOffset(characterDataWrapper.getData().getTotal());
			} else {
				con.setOffset(con.getOffset() + 100);
			}

		} catch (UniformInterfaceException e) {
			con.setOffset(con.getOffset());
			getCharacters();
		}

	} while (con.getOffset() != characterDataWrapper.getData().getTotal());

	}

	public List<Comic> getComics(String url) {
		Collection<ComicDataWrapper> list = new ArrayList<ComicDataWrapper>();
		ComicDataWrapper comicDataWrapper = new ComicDataWrapper();
		List<Comic> listaComic = new ArrayList<>();
		
	 do {
		con.setTimestamp(String.valueOf(System.currentTimeMillis()));
		con.setMd5(Utils.toMd5(con.getTimestamp() + con.getPrivateKey() + con.getPublicKey()));
		con.setLimit(100);
		Gson gson = new Gson();
		Client c = Client.create();
		WebResource wr = c.resource(url + "?ts=" + con.getTimestamp()
				+ "&apikey=" + con.getPublicKey() + "&hash=" + con.getMd5() + "&limit=" + con.getLimit() + "&offset="
				+ con.getOffset());
		try {
			String jstring = "[" + wr.get(String.class) + "]";
			jstring = jstring.replaceAll(":\"-000", ":\"000");
			

			Type collectionType = new TypeToken<Collection<ComicDataWrapper>>() {
			}.getType();
			list = gson.fromJson(jstring, collectionType);
			
			
			for (Iterator<ComicDataWrapper> iterator = list.iterator(); iterator.hasNext();) {
				comicDataWrapper = (ComicDataWrapper) iterator.next();
				if(comicDataWrapper.getData().getTotal() == 0) {
					return listaComic;
				} 
				for (int i = 0; i < comicDataWrapper.getData().getResults().length; i++) {
					 listaComic.add(comicDataWrapper.getData().getResults()[i]);
				}
			}
			if (con.getOffset() + 100 > comicDataWrapper.getData().getTotal()) {
				con.setOffset(comicDataWrapper.getData().getTotal());
			} else {
				con.setOffset(con.getOffset() + 100);
			}

		} catch (UniformInterfaceException e) {
			con.setOffset(con.getOffset());
			getCharacters();
		} catch (Exception e){
			e.printStackTrace();
		}

	} while (con.getOffset() != comicDataWrapper.getData().getTotal());
		return listaComic;
	}

}
