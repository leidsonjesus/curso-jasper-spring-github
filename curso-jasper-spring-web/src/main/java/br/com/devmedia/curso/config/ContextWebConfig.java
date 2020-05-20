package br.com.devmedia.curso.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ContextWebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] {SpringWebMvcConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class<?>[] {SpringWebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		ServletRegistration.Dynamic imageServlet = 
				servletContext.addServlet("ImageServlet", net.sf.jasperreports.j2ee.servlets.ImageServlet.class);
		imageServlet.addMapping("/image/*");
		super.onStartup(servletContext);
	}

	
}
