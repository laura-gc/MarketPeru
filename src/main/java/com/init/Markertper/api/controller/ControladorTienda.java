package com.init.Markertper.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.init.Markertper.api.interfacesservice.ITiendaService;
import com.init.Markertper.api.modelo.Tienda;

@Controller
@RequestMapping
public class ControladorTienda {
	@Autowired
	private ITiendaService service;
	
	//Para ir a la lista de todo los registros
	@RequestMapping(value = "listarTienda",method = RequestMethod.GET)
	public String listarTienda(Model model) {
		List<Tienda>tienda=service.BuscarTodosTienda();
		model.addAttribute("tienda", tienda);
		return "listarTienda";
	}
	
	//Para ir a crear nuevo registro
	@RequestMapping(value = "crearTienda",method = RequestMethod.GET)
	public String crearTienda(Model model) {
		model.addAttribute("tienda", new  Tienda());
		return "crearTienda";
	}
	
	//Para guardar el nuevo registro y ir a listar
	@PostMapping("guardarTienda")
	public String guardarTienda(@Validated Tienda t,Model model) {
		service.guardarTienda(t);
		return "redirect:/listarTienda";
	}
	
	//Para ir a editar el registro
	@GetMapping("editarTienda/{idTienda}")
	public String editarTienda(@PathVariable int idTienda,Model model) {
		Optional<Tienda>tienda=service.BuscarPorIdTienda(idTienda);
		model.addAttribute("tienda", tienda);
		return "crearTienda";
	}
	
	//Para ir a eliminar el registro
	@GetMapping("eliminarTienda/{idTienda}")
	public String eliminarTienda(Model model,@PathVariable int idTienda) {
		service.eliminarTienda(idTienda);
		return "redirect:/listarTienda";
	}
}
