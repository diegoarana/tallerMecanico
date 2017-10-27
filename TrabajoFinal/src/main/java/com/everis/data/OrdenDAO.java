package com.everis.data;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.everis.model.Orden;

public class OrdenDAO implements IOrdenDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public Orden getOrden(Long id) {
		Session session = sessionFactory.openSession();
		Orden orden = (Orden) session.load(Orden.class, id);
		session.close();
		return orden;
	}

	public List<Orden> listOrdenes() {
		Session session = sessionFactory.openSession();
		//List<Orden> listaOrdenes = session.createQuery("from Orden").list();
		Query q = session.createQuery("from Orden ORDER BY estado, fecha_ingreso ASC");
		List<Orden> listaOrdenes = q.getResultList();
		session.close();
		return listaOrdenes;
	}

	@Transactional
	public void addOrden(Orden orden) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(orden);
		tx.commit();
		session.close();
		
	}
	
	@Transactional
	public void updateOrden(Orden orden) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(orden);
		tx.commit();
		session.close();
		
	}

}
