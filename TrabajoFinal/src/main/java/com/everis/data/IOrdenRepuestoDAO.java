package com.everis.data;

import java.util.List;

import com.everis.model.OrdenRepuesto;

public interface IOrdenRepuestoDAO {
	
	public void addOrdenRepuesto(OrdenRepuesto ordenRepuesto);
	
	public List<OrdenRepuesto> listRepuesto(Long id);

}
