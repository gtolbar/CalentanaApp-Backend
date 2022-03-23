package com.calentanaApp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.calentanaApp.exception.ModeloNotFoundException;
import com.calentanaApp.model.EstadoInsumo;
import com.calentanaApp.service.IEstadoInsumoService;

@RestController
@RequestMapping("/estado_insumos")
public class EstadoInsumoController {
	
	@Autowired
	private IEstadoInsumoService service;
	
	@GetMapping
	public ResponseEntity<List<EstadoInsumo>> listar() throws Exception{
		List<EstadoInsumo> lista= service.listar();
		return new ResponseEntity<List<EstadoInsumo>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstadoInsumo> listarPorId(@PathVariable Integer id) throws Exception{
		EstadoInsumo obj= service.listarPorId(id);
		return new ResponseEntity<EstadoInsumo>(obj,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<EstadoInsumo> registrar(@RequestBody EstadoInsumo p) throws Exception{
		EstadoInsumo obj= service.registrar(p);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<EstadoInsumo> actualizar(@RequestBody EstadoInsumo p) throws Exception{
		EstadoInsumo obj= service.registrar(p);
		return new ResponseEntity<EstadoInsumo>(obj,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
		EstadoInsumo obj= service.listarPorId(id);
		if (obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+ id); 
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
