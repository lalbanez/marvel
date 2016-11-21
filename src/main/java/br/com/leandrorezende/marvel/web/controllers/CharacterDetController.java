package br.com.leandrorezende.marvel.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.leandrorezende.marvel.web.model.character.Character;
import br.com.leandrorezende.marvel.web.model.comic.Comic;
import br.com.leandrorezende.marvel.web.repository.CharacterRepository;
import br.com.leandrorezende.marvel.web.service.ConexaoService;

@Controller
public class CharacterDetController {

	@Autowired
	private CharacterRepository characterCrud;

//	@Autowired
//	private CharacterRepository comicCrud;

	@Autowired
	public ConexaoService service;

	@RequestMapping(value = "/character",	method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView method9(@RequestParam("id") int id, Model model) {
		Character c = characterCrud.findOne(new Long(id));
		List<Comic> comic = new ArrayList<>();
		ConexaoService.con.setOffset(0);
		comic = service.getComics("https://gateway.marvel.com/v1/public/characters/" + id +"/comics");
		ModelAndView mv = new ModelAndView("home/character");
		

		mv.addObject("comic", comic);
		mv.addObject("character", c);
		return mv;
	}
}
