package com.everis.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Repuesto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	
	private int precio;
	
	@OneToMany(mappedBy="repuesto")
	private List<OrdenRepuesto> listaOrdenes = new ArrayList<OrdenRepuesto>();
	
	public Repuesto(){}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public List<OrdenRepuesto> getListaOrdenes() {
		return listaOrdenes;
	}


	public void setListaOrdenes(List<OrdenRepuesto> listaOrdenes) {
		this.listaOrdenes = listaOrdenes;
	}
	
	
	
}
