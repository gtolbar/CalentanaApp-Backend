package com.calentanaApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="insumos")
public class Insumo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="proveedor", nullable=false)
	private String proveedor;
	
	@Column(name="marca", nullable=false)
	private String marca;
	
	@Column(name="producto", nullable=false)
	private String producto;
	
	@Column(name="comentario")
	private String comentario;
	
	

}
