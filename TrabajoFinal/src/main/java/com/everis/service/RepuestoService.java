package com.everis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.data.IRepuestoDAO;
import com.everis.model.Repuesto;

public class RepuestoService implements IRepuestoService {
	
	@Autowired
	IRepuestoDAO repuestoDAO;

	public List<Repuesto> listRepuesto() {
		return repuestoDAO.listRepuesto();
	}

}
