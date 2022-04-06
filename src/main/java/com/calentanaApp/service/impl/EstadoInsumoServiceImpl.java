package com.calentanaApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calentanaApp.model.EstadoInsumo;
import com.calentanaApp.repo.IEstadoInsumoRepo;
import com.calentanaApp.repo.IGenericRepo;
import com.calentanaApp.service.IEstadoInsumoService;

@Service
public class EstadoInsumoServiceImpl extends CRUDImpl<EstadoInsumo, Integer> implements IEstadoInsumoService{
	
	@Autowired
	private IEstadoInsumoRepo repo;
	
	@Override
	protected IGenericRepo<EstadoInsumo, Integer> getRepo() {
		return repo;
	}
	

	
}
