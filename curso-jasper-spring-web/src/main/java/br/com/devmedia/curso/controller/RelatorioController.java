package br.com.devmedia.curso.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.devmedia.curso.repository.ContatoRepository;
import br.com.devmedia.curso.repository.GraficoViewRepository;

@Controller
@RequestMapping("jasper")
public class RelatorioController {

	@Autowired
	private ContatoRepository repository;
	@Autowired
	private GraficoViewRepository graficoRepository;
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping(value = "/findGraficoViewHtml/{format}")
	public String getGraficoViewHTML(@PathVariable("format") String format, ModelMap model, HttpServletRequest request) 
			throws SQLException {
		
		model.addAttribute("JRCollection", graficoRepository.findGraicoView());
		model.addAttribute("format", format);
		model.addAttribute("REPORT_CONNECTION", dataSource.getConnection());
		model.addAttribute("requestObject", request);
		return "htmlGrafico";
	}
	
	@RequestMapping(value = "/findGraficoViewPdf/{format}")
	public String getGraficoViewPDF(@PathVariable("format") String format, ModelMap model) {
		
		model.addAttribute("JRCollection", graficoRepository.findGraicoView());
		model.addAttribute("format", format);
		
		return "findCidadesFones";
	}
	
	@RequestMapping(value = "/findChecked", method = RequestMethod.GET)
	public String getSelecao(
			@RequestParam("format") String format, 
			@RequestParam(value = "id", required = false) List<Long> ids, 
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "asc") String direction,
			ModelMap model) {
		
		Sort sort = new Sort(new Order(Direction.fromString(direction), orderBy));
		
		if (ids == null) {
			model.addAttribute("JRCollection", repository.findAll(sort));
		} else {
			model.addAttribute("JRCollection", repository.findByIdIn(ids, sort));
		}

		model.addAttribute("format", format);
		
		return "findContatos";
	}
	
	@RequestMapping(value = "/findByFormat", params = {"format"}, method = RequestMethod.GET)
	public String getReportByFormat(@RequestParam("format") String format, ModelMap model) {
		model.addAttribute("JRCollection", repository.findAll());
		model.addAttribute("format", format);
		return "findContatos";
	}
	
	@RequestMapping(value = "/findAllPdf", method = RequestMethod.GET)
	public String getAllPdf(ModelMap model) {
		model.addAttribute("JRCollection", repository.findAll());
		model.addAttribute("format", "pdf");
		//model.addAttribute("SUB_REPORT_DIR", "./relatorios/");
		//return "findAll";
		return "findContatos";
	}
	
	@RequestMapping(value = "/findAllHtml", method = RequestMethod.GET)
	public String getAllHtml(ModelMap model) {
		model.addAttribute("JRCollection", repository.findAll());
		model.addAttribute("format", "html");
		//model.addAttribute("SUB_REPORT_DIR", "./relatorios/");
		//return "findAll";
		return "findContatos";
	}
	
	@RequestMapping(value = "/findAllCsv", method = RequestMethod.GET)
	public String getAllCsv(ModelMap model) {
		model.addAttribute("JRCollection", repository.findAll());
		model.addAttribute("format", "csv");
		//model.addAttribute("SUB_REPORT_DIR", "./relatorios/");
		//return "findAll";
		return "findContatos";
	}
}
