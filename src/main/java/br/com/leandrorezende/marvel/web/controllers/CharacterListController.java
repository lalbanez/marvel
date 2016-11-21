package br.com.leandrorezende.marvel.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.leandrorezende.marvel.web.model.character.Conexao;
import br.com.leandrorezende.marvel.web.repository.CharacterRepository;
import br.com.leandrorezende.marvel.web.service.ConexaoService;

@Controller
public class CharacterListController {

	@Autowired
	public ConexaoService service;

	@Autowired
	private CharacterRepository characterCrud;

	@RequestMapping(value = "/characters")
	public ModelAndView listar(Conexao con, RedirectAttributes redirectAttributes) {
		con.setOffset(0);
		ConexaoService.con = con;
		service.getCharacters();
		ModelAndView mv = new ModelAndView("home/characters");
		mv.addObject("characters", characterCrud.findAll());
		return mv;
	}

}
