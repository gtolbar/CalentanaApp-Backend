package com.calentanaApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calentanaApp.service.IInformeService;


@RestController
@RequestMapping("/informes")
public class InformeController {
	
	@Autowired
	private IInformeService service;
	
	@GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte(@RequestParam(value = "fechaInicio") String fechaInicio,@RequestParam(value = "fechaFinal") String fechaFinal) {
		byte[] data = null;
		data = service.generarReporte(fechaInicio,fechaFinal);
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}
	

}
