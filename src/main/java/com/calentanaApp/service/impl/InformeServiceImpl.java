package com.calentanaApp.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.calentanaApp.dto.ConsultaPdfDTO;
import com.calentanaApp.repo.IEstadoInsumoRepo;
import com.calentanaApp.service.IInformeService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class InformeServiceImpl implements IInformeService{
	
	@Autowired
	private IEstadoInsumoRepo repo;
	
	@Override
	public List<ConsultaPdfDTO> listarResumen(String fechaInicio,String fechaFinal){
		List<ConsultaPdfDTO> consultas = new ArrayList<>();
		repo.listarResumen(fechaInicio,fechaFinal).forEach(x->{
			ConsultaPdfDTO cs =new ConsultaPdfDTO();
			cs.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cs.setFecha(String.valueOf(x[1]));
			consultas.add(cs);
		});
		return consultas; 
	}
	
	
	@Override
	public byte[] generarReporte(String fechaInicio,String fechaFinal) {
		byte[] data = null;
		String nombre = "Del "+fechaInicio+" hasta "+fechaFinal;
		//poblar parametros
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("txt_mes", nombre.toUpperCase().charAt(0)+nombre.substring(1, nombre.length()).toLowerCase());
		
		try {
			File file = new ClassPathResource("/reports/InformeCalentana.jasper").getFile();
			//System.out.println(System.getProperty("user.dir") + "src\\main\\resources\\reports\\Holamundo.jasper");
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), parametros, new JRBeanCollectionDataSource(this.listarResumen(fechaInicio,fechaFinal)));
			data = JasperExportManager.exportReportToPdf(print);
			// mitocode jasperreports | excel, pdf, ppt, word, csv
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
}
