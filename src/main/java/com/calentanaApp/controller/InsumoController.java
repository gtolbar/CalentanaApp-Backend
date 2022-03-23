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
import com.calentanaApp.model.Insumo;
import com.calentanaApp.service.IInsumoService;

@RestController
@RequestMapping("/insumos")
public class InsumoController {
	
	@Autowired
	private IInsumoService service;
	
	@GetMapping
	public ResponseEntity<List<Insumo>> listar() throws Exception{
		List<Insumo> lista= service.listar();
		return new ResponseEntity<List<Insumo>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Insumo> listarPorId(@PathVariable Integer id) throws Exception{
		Insumo obj= service.listarPorId(id);
		return new ResponseEntity<Insumo>(obj,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Insumo> registrar(@RequestBody Insumo p) throws Exception{
		Insumo obj= service.registrar(p);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Insumo> actualizar(@RequestBody Insumo p) throws Exception{
		Insumo obj= service.registrar(p);
		return new ResponseEntity<Insumo>(obj,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
		Insumo obj= service.listarPorId(id);
		if (obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+ id); 
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
