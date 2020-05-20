package br.com.devmedia.curso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.devmedia.curso.entity.Contato;
import br.com.devmedia.curso.repository.ContatoRepository;

@Controller
public class HelloController {
	
	@Autowired
	private ContatoRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView hello(ModelMap model) {
		
		model.addAttribute("listaDeContatos", repository.findAll());
		
		return new ModelAndView("contatos", model);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView hello(
		@RequestParam("nome") String nome, @RequestParam("cidade") String cidade) {
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		if (!nome.isEmpty() && !cidade.isEmpty()) {
			contatos = repository.findByNomeAndCidade(nome, cidade);
		} else if (!nome.isEmpty()) {
			contatos = repository.findBySobrenome(nome);
		} else if (!cidade.isEmpty()) {
			contatos = repository.findByEnderecoCidadeOrderByNomeAsc(cidade);
		}
		
		return new ModelAndView("contatos", "listaDeContatos", contatos);
	}
}
