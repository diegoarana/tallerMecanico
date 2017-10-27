package com.everis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Orden {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String patente;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_ingreso;
	
	private String marca;
	
	private String modelo;
	
	private String detalle;
	
	private String estado;
	
	private int cantidad_horas;
	
	private int costoFinal;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idEmpleado")
	private Empleado empleado;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idPropietario")
	private Propietario propietario;
	
	@OneToMany(mappedBy="orden")
	private List<OrdenRepuesto> listaRepuestos = new ArrayList<OrdenRepuesto>();
	
	
	public Orden(){}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	
	public List<OrdenRepuesto> getListaRepuestos() {
		return listaRepuestos;
	}

	public void setListaRepuestos(List<OrdenRepuesto> listaRepuestos) {
		this.listaRepuestos = listaRepuestos;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCantidad_horas() {
		return cantidad_horas;
	}
	public void setCantidad_horas(int cantidad_horas) {
		this.cantidad_horas = cantidad_horas;
	}
	public int getCostoFinal() {
		return costoFinal;
	}
	public void setCostoFinal(int costoFinal) {
		this.costoFinal = costoFinal;
	}
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

}
