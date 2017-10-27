package com.everis.data;

import java.util.List;

import com.everis.model.Repuesto;

public interface IRepuestoDAO {
	
	public List<Repuesto> listRepuesto();
	
	public Repuesto getRepuesto(Long id);

}
