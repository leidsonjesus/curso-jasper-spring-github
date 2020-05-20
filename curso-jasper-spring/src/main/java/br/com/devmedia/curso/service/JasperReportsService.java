package br.com.devmedia.curso.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

@Service
public class JasperReportsService {
	
	public void compileReport(String jasperFile, Map<String, Object> params, Collection<?> collection) {
		
		try {
			
			JasperReport report = JasperCompileManager.compileReport(jasperFile);
			
			JasperPrint print = JasperFillManager.fillReport(
					report, 
					params, 
					new JRBeanCollectionDataSource(collection));
			
			JasperViewer viewer = new JasperViewer(print);
			viewer.setVisible(true);
			
		} catch (JRException e) {

			e.printStackTrace();
		}
	}
	
	public void openReportByHTML(String jasperFile, String outFile, Map<String, Object> params, Collection<?> collection) {
		
		try {
			JasperPrint print = JasperFillManager.fillReport(
					jasperFile, 
					params, 
					new JRBeanCollectionDataSource(collection));
			
			JasperExportManager.exportReportToHtmlFile(print, outFile);
			
		} catch (JRException e) {
			
			e.printStackTrace();
		}
	}
	
	public void openReportByPDF(String jasperFile, String outFile, Map<String, Object> params, Collection<?> collection) {
		
		try {
			JasperPrint print = JasperFillManager.fillReport(
					jasperFile, 
					params, 
					new JRBeanCollectionDataSource(collection));
			
			JasperExportManager.exportReportToPdfFile(print, outFile);
			
		} catch (JRException e) {
			
			e.printStackTrace();
		}
	}

	public void openReportByJasper(String jasperFile, Map<String, Object> params, Collection<?> collection) {
		
		try {
			JasperPrint print = JasperFillManager.fillReport(
					jasperFile, 
					params, 
					new JRBeanCollectionDataSource(collection));
			
			JasperViewer viewer = new JasperViewer(print);
			viewer.setVisible(true);
			
		} catch (JRException e) {

			e.printStackTrace();
		}
	}
}
