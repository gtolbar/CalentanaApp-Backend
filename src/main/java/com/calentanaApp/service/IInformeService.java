package com.calentanaApp.service;

import java.util.List;

import com.calentanaApp.dto.ConsultaPdfDTO;

public interface IInformeService{
	
	List<ConsultaPdfDTO> listarResumen(String fechaInicio,String fechaFinal);
	
	byte[] generarReporte(String fechaInicio,String fechaFinal);

}
