package br.com.devmedia.curso.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;

public class JasperToHtmlViewConfig extends JasperReportsMultiFormatView {

	@Override
	protected void renderReport(JasperPrint populatedReport, Map<String, Object> model, HttpServletResponse response)
			throws Exception {
		
		if (model.containsKey("requestObject")) {
			
			HttpServletRequest request = (HttpServletRequest) model.get("requestObject");
			request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, populatedReport);
		}
		
		super.renderReport(populatedReport, model, response);
	}

}
