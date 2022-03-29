package com.calentanaApp.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ConsultaPdfDTO {
	
	private String producto;
	private Integer precio;
	private Integer cantidad;
	private LocalDate fecha;

}
