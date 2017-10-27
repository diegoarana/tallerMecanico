package com.everis.data;

import java.util.List;

import com.everis.model.Propietario;

public interface IPropietarioDAO {
	
	public void addPropietario(Propietario propietario);
	
	public List<Propietario> listPropietarios();

}
