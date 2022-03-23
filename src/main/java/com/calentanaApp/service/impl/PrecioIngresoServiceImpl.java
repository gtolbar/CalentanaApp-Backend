package com.calentanaApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calentanaApp.model.PrecioIngreso;
import com.calentanaApp.repo.IGenericRepo;
import com.calentanaApp.repo.IPrecioIngresoRepo;
import com.calentanaApp.service.IPrecioIngresoService;


@Service
public class PrecioIngresoServiceImpl extends CRUDImpl<PrecioIngreso, Integer> implements IPrecioIngresoService{
	
	@Autowired
	private IPrecioIngresoRepo repo;
	
	@Override
	protected IGenericRepo<PrecioIngreso, Integer> getRepo() {
		return repo;
	}

}
