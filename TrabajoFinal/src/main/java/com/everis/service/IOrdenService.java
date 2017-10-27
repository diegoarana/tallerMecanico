package com.everis.service;

import java.util.List;

import com.everis.model.Orden;

public interface IOrdenService {
	
public Orden getOrden(Long id);
	
	public List<Orden> listOrdenes();
	
	public void addOrden(Orden orden);
	
	public void updateOrden(Orden orden);

}
