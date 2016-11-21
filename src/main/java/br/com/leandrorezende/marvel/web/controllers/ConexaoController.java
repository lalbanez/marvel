package br.com.leandrorezende.marvel.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.leandrorezende.marvel.web.model.character.Conexao;

@Controller
public class ConexaoController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("home/index");
		mv.addObject(new Conexao());
		return mv;
	}

}
