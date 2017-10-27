package com.everis.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.everis.model.Orden;
import com.everis.model.Repuesto;

public class RepuestoDAO implements IRepuestoDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public List<Repuesto> listRepuesto() {
		Session session = sessionFactory.openSession();
		List<Repuesto> listaRepuestos = session.createQuery("from Repuesto").list();
		session.close();
		return listaRepuestos;
	}
	
	@Transactional
	public Repuesto getRepuesto(Long id) {
		Session session = sessionFactory.openSession();
		Repuesto repuesto = (Repuesto) session.load(Repuesto.class, id);
		session.close();
		return repuesto;
	}

}
