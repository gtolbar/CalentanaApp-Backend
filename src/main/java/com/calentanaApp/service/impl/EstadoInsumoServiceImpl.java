package com.calentanaApp.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
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
	public byte[] generarReporte() {
		System.out.println(this.listarVariablesPDF());
		byte[] data = null;
		//poblar parametros
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("txt_mes", "Marzo");

		try {
			File file = new ClassPathResource("/reports/InformeCalentana.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), parametros, new JRBeanCollectionDataSource(this.listarVariablesPDF()));
			data = JasperExportManager.exportReportToPdf(print);
			// mitocode jasperreports | excel, pdf, ppt, word, csv
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<ConsultaPdfDTO> listarVariablesPDF() {
		// TODO Auto-generated method stub
		return repo.listarVariablesPDF();
	}

}
