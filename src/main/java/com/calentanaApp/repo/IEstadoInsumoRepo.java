package com.calentanaApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.calentanaApp.dto.ConsultaPdfDTO;
import com.calentanaApp.model.EstadoInsumo;

public interface IEstadoInsumoRepo extends IGenericRepo<EstadoInsumo, Integer>{
	
	//@Query(value="SELECT i.producto,p.precio,ei.cantidad,ei.fecha FROM estado_insumos AS ei JOIN precio_ingreso AS p ON ei.id_precio_ingreso=p.id JOIN insumos AS i ON ei.id_insumos=i.id", nativeQuery = true)
	//@Query(value="SELECT i.producto,p.precio,ei.cantidad,ei.fecha FROM estado_insumos AS ei JOIN precio_ingreso AS p ON ei.id_precio_ingreso=p.id JOIN insumos AS i ON ei.id_insumos=i.id")
	@Query(value="SELECT i.producto,p.precio,ei.cantidad,ei.fecha FROM EstadoInsumo ei JOIN PrecioIngreso p ON ei.idPrecioIngreso=p.id JOIN Insumo i ON ei.idInsumos=i.id")
	//@Query(value="SELECT i.producto,p.precio,ei.cantidad,ei.fecha FROM EstadoInsumo ei JOIN PrecioIngreso p ON ei.id_precio_ingreso=p.id JOIN Insumo i ON ei.id_insumos=i.id")
	public List<ConsultaPdfDTO> listarVariablesPDF();

}
