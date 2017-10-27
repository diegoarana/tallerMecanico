package com.everis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.data.IOrdenDAO;
import com.everis.model.Orden;

public class OrdenService implements IOrdenService {
	
	@Autowired
	IOrdenDAO ordenDAO;

	public Orden getOrden(Long id) {
		return ordenDAO.getOrden(id);
	}

	public List<Orden> listOrdenes() {
		return ordenDAO.listOrdenes();
	}

	public void addOrden(Orden orden) {
		ordenDAO.addOrden(orden);
		
	}

	public void updateOrden(Orden orden) {
		ordenDAO.updateOrden(orden);
		
	}

}
