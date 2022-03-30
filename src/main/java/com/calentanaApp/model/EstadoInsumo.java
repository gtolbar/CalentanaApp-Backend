package com.calentanaApp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="estado_insumos")
public class EstadoInsumo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cantidad", nullable=false)
	private int cantidad;
	
	@Column(name="fecha", nullable=false)
	private LocalDate fecha;
	
	@Column(name="accion", nullable=false)
	private boolean accion;
	
	@Column(name="comentario")
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name="id_insumos")
	private Insumo idInsumos;
	
	@ManyToOne
	@JoinColumn(name="id_precio_ingresos")
	private PrecioIngreso idPrecioIngresos;

}
