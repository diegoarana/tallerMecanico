package com.everis.data;

import java.util.List;

import com.everis.model.Empleado;
import com.everis.model.Orden;

public interface IEmpleadoDAO {
	
	public Empleado getEmpleado(Long id);
	
	public List<Empleado> listEmpleados();

}
