package com.calentanaApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calentanaApp.model.Insumo;
import com.calentanaApp.repo.IGenericRepo;
import com.calentanaApp.repo.IInsumoRepo;
import com.calentanaApp.service.IInsumoService;

@Service
public class InsumoServiceImpl extends CRUDImpl<Insumo, Integer> implements IInsumoService{
	
	@Autowired
	private IInsumoRepo repo;
	
	@Override
	protected IGenericRepo<Insumo, Integer> getRepo() {
		return repo;
	}

}
