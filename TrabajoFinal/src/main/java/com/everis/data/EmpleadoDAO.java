package com.everis.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.everis.model.Empleado;

public class EmpleadoDAO implements IEmpleadoDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public List<Empleado> listEmpleados() {
		
		Session session = sessionFactory.openSession();
		List<Empleado> listaEmpleados = session.createQuery("from Empleado").list();
		session.close();
		return listaEmpleados;
	}

	public Empleado getEmpleado(Long id) {
		Session session = sessionFactory.openSession();
		Empleado empleado = (Empleado) session.load(Empleado.class, id);
		session.close();
		return empleado;
	}

}
