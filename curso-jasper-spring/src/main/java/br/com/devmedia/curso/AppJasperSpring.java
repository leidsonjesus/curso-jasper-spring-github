package br.com.devmedia.curso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.devmedia.curso.entity.Contato;
import br.com.devmedia.curso.repository.ContatoRepository;
import br.com.devmedia.curso.service.JasperReportsService;

public class AppJasperSpring {
	
	private static final String DIR_RELATORIOS = "./relatorios/";
	
	private static final String DIR_SAIDA_RELATORIOS = "C:\\Users\\Ballem\\workspace-devmedia\\curso-jasper-spring\\exports\\";

	private ContatoRepository repository;
	
	private JasperReportsService service;
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("br.com.devmedia.curso");
		ctx.refresh();
		
		AppJasperSpring app = new AppJasperSpring();
		app.repository = ctx.getBean(ContatoRepository.class);
		app.service = ctx.getBean(JasperReportsService.class);
		//System.out.println("Total de Contatos: " + app.repository.count());
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("SUB_REPORT_DIR", DIR_RELATORIOS);
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		//contatos = app.repository.findAll();
		//contatos = app.repository.findByNome("Rivaldo Pires");
		//contatos = app.repository.findByEnderecoCidadeOrderByNomeAsc("Porto Alegre");
		contatos = app.repository.findBySobrenome("Silva");
		//app.relatorioContatosByFindAll(params, contatos);
		//app.relatorioPDF(params, contatos);
		//app.relatorioHTML(params, contatos);
		app.relatorioACompilar(params, contatos);
	}

	private void relatorioACompilar(Map<String, Object> params, List<Contato> contatos) {
		
		service.compileReport(DIR_RELATORIOS + "findContatos.jrxml", params, contatos);
		
	}

	private void relatorioHTML(Map<String, Object> params, List<Contato> contatos) {
		
		service.openReportByHTML(
				DIR_RELATORIOS + "findContatos.jasper",
				DIR_SAIDA_RELATORIOS + "contatos_" + System.currentTimeMillis() + ".html", 
				params, 
				contatos);
		
	}

	private void relatorioPDF(Map<String, Object> params, List<Contato> contatos) {
		
		service.openReportByPDF(
				DIR_RELATORIOS + "findContatos.jasper",
				DIR_SAIDA_RELATORIOS + "contatos_" + System.currentTimeMillis() + ".pdf", 
				params, 
				contatos);
		
	}

	private void relatorioContatosByFindAll(Map<String, Object> params, List<Contato> contatos) {
		
		service.openReportByJasper(DIR_RELATORIOS + "findContatos.jasper", params , contatos);
		
	}
}
