package com.everis.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class OrdenRepuesto implements Serializable{
	
	private int cantidad;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="idOrden")
	private Orden orden;
	
	@Id
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name="idRepuesto")
	private Repuesto repuesto;
	
	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Repuesto getRepuesto() {
		return repuesto;
	}

	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	public OrdenRepuesto(){
		
	}


	
}
