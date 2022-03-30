package com.calentanaApp.service.impl;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.calentanaApp.dto.ConsultaPdfDTO;
import com.calentanaApp.model.EstadoInsumo;
import com.calentanaApp.repo.IEstadoInsumoRepo;
import com.calentanaApp.repo.IGenericRepo;
import com.calentanaApp.service.IEstadoInsumoService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EstadoInsumoServiceImpl extends CRUDImpl<EstadoInsumo, Integer> implements IEstadoInsumoService{
	
	@Autowired
	private IEstadoInsumoRepo repo;
	
	@Override
	protected IGenericRepo<EstadoInsumo, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public List<ConsultaPdfDTO> listarResumen(){
		List<ConsultaPdfDTO> consultas = new ArrayList<>();
		repo.listarResumen().forEach(x->{
			ConsultaPdfDTO cs =new ConsultaPdfDTO();
			cs.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cs.setFecha(String.valueOf(x[1]));
			consultas.add(cs);
		});
		return consultas; 
	}
	
	
	@Override
	public byte[] generarReporte() {
		byte[] data = null;
		Month mes = LocalDate.now().getMonth();
		String nombre = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		//poblar parametros
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("txt_mes", nombre.toUpperCase().charAt(0)+nombre.substring(1, nombre.length()).toLowerCase());
		
		try {
			File file = new ClassPathResource("/reports/InformeCalentana.jasper").getFile();
			//System.out.println(System.getProperty("user.dir") + "src\\main\\resources\\reports\\Holamundo.jasper");
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), parametros, new JRBeanCollectionDataSource(this.listarResumen()));
			data = JasperExportManager.exportReportToPdf(print);
			// mitocode jasperreports | excel, pdf, ppt, word, csv
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
}
