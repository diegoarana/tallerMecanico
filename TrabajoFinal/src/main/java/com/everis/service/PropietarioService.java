package com.everis.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.data.IPropietarioDAO;
import com.everis.data.PropietarioDAO;
import com.everis.model.Propietario;

public class PropietarioService implements IPropietarioService{
	
	@Autowired
	IPropietarioDAO propietarioDAO;

	public void addPropietario(Propietario propietario) {
		propietarioDAO.addPropietario(propietario);
		
	}

}
