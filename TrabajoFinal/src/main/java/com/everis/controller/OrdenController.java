package com.everis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.GenericTypeAwareAutowireCandidateResolver;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.everis.data.IEmpleadoDAO;
import com.everis.data.IOrdenRepuestoDAO;
import com.everis.data.IPropietarioDAO;
import com.everis.data.IRepuestoDAO;
import com.everis.model.Orden;
import com.everis.model.OrdenRepuesto;
import com.everis.model.Repuesto;
import com.everis.service.IOrdenService;

@Controller
@RequestMapping("Orden")
public class OrdenController {
	
	@Autowired
	IOrdenService ordenService;
	
	@Autowired
	IEmpleadoDAO empleadoDAO;
	
	@Autowired
	IPropietarioDAO propietarioDAO;
	
	@Autowired
	IRepuestoDAO repuestoDAO;
	
	@Autowired
	IOrdenRepuestoDAO ordenRepuestoDAO;
	
	@RequestMapping("/")
	public ModelAndView lista(){
		List<Orden> listaOrden = ordenService.listOrdenes();
		return new ModelAndView("Orden/Lista", "listaOrden", listaOrden);
	}
	
	@RequestMapping("Nuevo")
	public ModelAndView Nuevo(){
		//Nuevo MaV con View
		ModelAndView m = new ModelAndView("Orden/Nuevo");
		//Agrego los modelos
		m.addObject("orden", new Orden());
		m.addObject("listaEmpleados", empleadoDAO.listEmpleados());
		m.addObject("listaPropietarios", propietarioDAO.listPropietarios());
		return m;
	}
	
	@RequestMapping(path="Nuevo", method=RequestMethod.POST)
	public String IniciarOrden(@ModelAttribute("orden")Orden o){
		ordenService.addOrden(o);
		return "redirect:/Orden/";
	}
	
	
	@RequestMapping("Finalizar/{id}")
	public ModelAndView Finalizar(@PathVariable("id")Long id){
		
		ModelAndView m = new ModelAndView("Orden/Finalizar");
		
		Orden o = null;
		try{
		 o = ordenService.getOrden(id);
		}
		catch(org.hibernate.ObjectNotFoundException er){
			o = null;
		}
		
		String fecha = o.getFecha_ingreso().toString();
		fecha = fecha.replace("-", "/");
		
		m.addObject("fecha", fecha);
		m.addObject("orden", o);
		m.addObject("listaRepuestos", repuestoDAO.listRepuesto());
		
		return m;
	}
	
	
	@RequestMapping(path="FinalizarOrden", method=RequestMethod.POST)
	public String FinalizarOrden(@ModelAttribute("orden")Orden orden, HttpServletRequest request ){
		
		int costo = orden.getCantidad_horas() * 150;

		Repuesto repuesto = null;
		
		OrdenRepuesto ordenRepuesto= new OrdenRepuesto();
		
		
		// Tomo la cantidad de cada repuesto desde la vista, y si es distinta de cero agrego el repuesto
		
		try{
		int cant1=Integer.parseInt(request.getParameter("1"));
		if (cant1 != 0){
			repuesto = repuestoDAO.getRepuesto(Long.parseLong("1"));
			ordenRepuesto.setOrden(orden);
			ordenRepuesto.setRepuesto(repuesto);
			ordenRepuesto.setCantidad(cant1);
			costo = costo + (repuesto.getPrecio()*cant1);
			ordenRepuestoDAO.addOrdenRepuesto(ordenRepuesto);
		}}catch(Exception e){
			e.getMessage();
		}
		
		try{
			int cant2=Integer.parseInt(request.getParameter("2"));
			if (cant2 != 0){
				repuesto = repuestoDAO.getRepuesto(Long.parseLong("2"));
				ordenRepuesto.setOrden(orden);
				ordenRepuesto.setRepuesto(repuesto);
				ordenRepuesto.setCantidad(cant2);
				costo = costo + (repuesto.getPrecio()*cant2);
				ordenRepuestoDAO.addOrdenRepuesto(ordenRepuesto);
			}}catch(Exception e){
				e.getMessage();
			}
		
		try{
			int cant3=Integer.parseInt(request.getParameter("3"));
			if (cant3 != 0){
				repuesto = repuestoDAO.getRepuesto(Long.parseLong("3"));
				ordenRepuesto.setOrden(orden);
				ordenRepuesto.setRepuesto(repuesto);
				ordenRepuesto.setCantidad(cant3);
				costo = costo + (repuesto.getPrecio()*cant3);
				ordenRepuestoDAO.addOrdenRepuesto(ordenRepuesto);
			}}catch(Exception e){
				e.getMessage();
			}
		
		try{
			int cant4=Integer.parseInt(request.getParameter("4"));
			if (cant4 != 0){
				repuesto = repuestoDAO.getRepuesto(Long.parseLong("4"));
				ordenRepuesto.setOrden(orden);
				ordenRepuesto.setRepuesto(repuesto);
				ordenRepuesto.setCantidad(cant4);
				costo = costo + (repuesto.getPrecio()*cant4);
				ordenRepuestoDAO.addOrdenRepuesto(ordenRepuesto);
			}}catch(Exception e){
				e.getMessage();
			}
		
		orden.setCostoFinal(costo);
		
		ordenService.updateOrden(orden);
		
		return "redirect:/Orden/";
	}
	
	@RequestMapping("CostoDetalle/{id}")
	public ModelAndView costoDetalle(@PathVariable("id")Long id){
		//Nuevo MaV con View
		ModelAndView m = new ModelAndView("Orden/CostoDetalle");
		
		Orden orden =ordenService.getOrden(id);
		List<OrdenRepuesto> listaOrdenRepuestos = ordenRepuestoDAO.listRepuesto(id);
		
		//Agrego los modelos
		m.addObject("orden", orden);
		m.addObject("listaOrdenRepuestos", listaOrdenRepuestos);
		return m;
	}

}
