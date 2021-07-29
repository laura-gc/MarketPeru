package com.init.Markertper.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.init.Markertper.api.interfacesservice.ITiendaService;
import com.init.Markertper.api.interfacesservice.IUsuarioService;
import com.init.Markertper.api.modelo.Tienda;
import com.init.Markertper.api.modelo.Usuario;

@Controller
@RequestMapping
public class ControladorUsuario {
	@Autowired
	private IUsuarioService service;
	
	@Autowired
	private ITiendaService tiendaService;
	
	//Para ir a la lista de todo los registros
	@RequestMapping(value = "listarUsuario",method = RequestMethod.GET)
	public String listarUsuario(Model model) {
		List<Usuario>usuario=service.BuscarTodosUsuario();
		model.addAttribute("usuario", usuario);
		return "listarUsuario";
	}
			
	//Para ir a crear nuevo registro con FK
	@RequestMapping(value = "/crearUsuario", method = RequestMethod.GET)
	public String crearUsuario(Model model) {
		Usuario usuario =new Usuario();
		
		List<Tienda> listadoTienda=tiendaService.BuscarTodosTienda();
		
		
		model.addAttribute("titulo","Agregar Usuario");
		model.addAttribute("usuario", usuario);
		model.addAttribute("lstTienda", listadoTienda);
		
		return "crearUsuario";
	}
	
	//Para guardar el nuevo registro y ir a listar
	@PostMapping("guardarUsuario")
	public String guardarUsuario(@ModelAttribute Usuario u,Model model) {
		service.guardarUsuario(u);
		return "redirect:/listarUsuario";
	}
	
	//Para ir a editar el registro
	@GetMapping("editarUsuario/{idUsuario}")
	public String editarUsuario(@PathVariable int idUsuario,Model model) {
		Optional<Usuario>usuario=service.BuscarPorIdUsuario(idUsuario);
		
		List<Tienda> listadoTienda=tiendaService.BuscarTodosTienda();
		
		model.addAttribute("titulo","Agregar Usuario");
		model.addAttribute("usuario", usuario);
		model.addAttribute("lstTienda", listadoTienda);

		
		return "crearUsuario";
	}
	
	//Para ir a eliminar el registro
	@GetMapping("eliminarUsuario/{idUsuario}")
	public String eliminarUsuario(Model model,@PathVariable int idUsuario) {
		service.eliminarUsuario(idUsuario);
		return "redirect:/listarUsuario";
	}
}
