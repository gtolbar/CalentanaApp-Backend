package com.calentanaApp.service;

import java.util.List;

import com.calentanaApp.dto.ConsultaPdfDTO;
import com.calentanaApp.model.EstadoInsumo;

public interface IEstadoInsumoService extends ICRUD<EstadoInsumo, Integer>{

	List<ConsultaPdfDTO> listarVariablesPDF();
	
	byte[] generarReporte();

}
