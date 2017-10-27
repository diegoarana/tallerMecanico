package com.everis.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.everis.model.Propietario;

public class PropietarioDAO implements IPropietarioDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void addPropietario(Propietario propietario) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(propietario);
		tx.commit();
		
	}

	public List<Propietario> listPropietarios() {
		Session session = sessionFactory.openSession();
		List<Propietario> listaPropietarios = session.createQuery("from Propietario").list();
		session.close();
		return listaPropietarios;
	}

}
