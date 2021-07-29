package com.init.Markertper.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.init.Markertper.api.interfacesservice.ICategoriasService;
import com.init.Markertper.api.modelo.Categorias;

@Controller
@RequestMapping
public class ControladorCategorias {
	
	
	@Autowired
	private ICategoriasService service;
	
	//Para ir a la lista de todo los registros
    @Secured({ "ROLE_ADMIN"})
	@RequestMapping(value = "listarCategoria",method = RequestMethod.GET)
	public String listarCategoria(Model model) {
		List<Categorias>categorias=service.BuscarTodosCategorias();
		model.addAttribute("categorias", categorias);
		return "listarCategoria";
	}
	
	//Para ir a crear nuevo registro
	@RequestMapping(value = "crearCategoria",method = RequestMethod.GET)
	public String crearCategoria(Model model) {
		model.addAttribute("categoria", new  Categorias());
		return "crearCategoria";
	}
	
	//Para guardar el nuevo registro y ir a listar
	@PostMapping("guardarCategoria")
	public String guardarCategoria(@Validated Categorias c,Model model) {
		service.guardarCategoria(c);
		return "redirect:/listarCategoria";
	}
	
	//Para ir a editar el registro
	@GetMapping("editarCategoria/{idCategoria}")
	public String editarCategoria(@PathVariable int idCategoria,Model model) {
		Optional<Categorias>categoria=service.BuscarPorIdCategoria(idCategoria);
		model.addAttribute("categoria", categoria);
		return "crearCategoria";
	}
	
	//Para ir a eliminar el registro
	@GetMapping("eliminarCategoria/{idCategoria}")
	public String eliminarCategoria(Model model,@PathVariable int idCategoria) {
		service.eliminarCategoria(idCategoria);
		return "redirect:/listarCategoria";
	}
}
