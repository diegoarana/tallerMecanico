package com.everis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.everis.model.Orden;
import com.everis.model.Propietario;
import com.everis.service.IPropietarioService;

@Controller
@RequestMapping("Propietario")
public class PropietarioController {
	
	@Autowired
	IPropietarioService propietarioService;
	
	@RequestMapping("Nuevo")
	public ModelAndView Nuevo(){
		//Nuevo MaV con View
		ModelAndView m = new ModelAndView("Propietario/Nuevo");
		//Agrego los modelos
		m.addObject("propietario", new Propietario());
		return m;
		}
	
	@RequestMapping(path="Nuevo", method=RequestMethod.POST)
	public String AltaPropietario(@ModelAttribute("propietario")Propietario p){
		propietarioService.addPropietario(p);
		return "redirect:/Orden/";
	}

}
