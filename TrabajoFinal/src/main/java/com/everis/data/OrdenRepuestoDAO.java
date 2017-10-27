package com.everis.data;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.everis.model.OrdenRepuesto;

public class OrdenRepuestoDAO implements IOrdenRepuestoDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void addOrdenRepuesto(OrdenRepuesto ordenRepuesto) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(ordenRepuesto);
		tx.commit();
		
	}
	
	public List<OrdenRepuesto> listRepuesto(Long id) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from OrdenRepuesto where idOrden = :id");
		q.setParameter("id", id);
		List<OrdenRepuesto> lista = q.getResultList();
		session.close();
		return lista;
	}

}
