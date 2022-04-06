package com.calentanaApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.calentanaApp.model.EstadoInsumo;

public interface IEstadoInsumoRepo extends IGenericRepo<EstadoInsumo, Integer>{
	

	//@Query(value="SELECT i.producto,p.precio,ei.cantidad,ei.fecha FROM EstadoInsumo ei JOIN PrecioIngreso p ON ei.idPrecioIngreso=p.id JOIN Insumo i ON ei.idInsumos=i.id")
	//public List<ConsultaPdfDTO> listarVariablesPDF();
	
	@Query(value="SELECT ei.cantidad,ei.fecha FROM estado_insumos ei WHERE ei.fecha BETWEEN :fechaInicio AND :fechaFinal", nativeQuery = true)
	List<Object[]> listarResumen(@Param("fechaInicio") String fechaInicio,@Param("fechaFinal") String fechaFinal);


}
