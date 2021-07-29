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

import com.init.Markertper.api.interfacesservice.ICategoriasService;
import com.init.Markertper.api.interfacesservice.IProductosService;
import com.init.Markertper.api.interfacesservice.IProveedoresService;
import com.init.Markertper.api.modelo.Categorias;
import com.init.Markertper.api.modelo.Productos;
import com.init.Markertper.api.modelo.Proveedores;

@Controller
@RequestMapping
public class ControladorProductos {

	@Autowired
	private IProductosService service;
	
	@Autowired
	private ICategoriasService categoriasService;
	
	@Autowired
	private IProveedoresService proveedorService;
	
	//Para ir a la lista de todo los registros
	@RequestMapping(value = "listarProductos",method = RequestMethod.GET)
	public String listarProductos(Model model) {
		List<Productos>productos=service.BuscarTodosProductos();
		model.addAttribute("productos", productos);
		return "listarProductos";
	}
	
	//Para ir a crear nuevo registro con FK
		@RequestMapping(value = "/crearProducto", method = RequestMethod.GET)
		public String crearProducto(Model model) {
			Productos productos =new Productos();
			
			List<Categorias> listadoCategorias=categoriasService.BuscarTodosCategorias();
			List<Proveedores> listadoProveedores = proveedorService.BuscarTodosProveedores();
						
			model.addAttribute("productos", productos);
			model.addAttribute("lstCategorias", listadoCategorias);
			model.addAttribute("lstProveedores", listadoProveedores);
			
			
			return "crearProducto";
		}
		
		//Para guardar el nuevo registro y ir a listar
		@PostMapping("guardarProducto")
		public String guardarProducto(@ModelAttribute Productos p,Model model) {
			service.guardarProducto(p);
			return "redirect:/listarProductos";
		}
		
		//Para ir a editar el registro
		@GetMapping("editarProducto/{idProducto}")
		public String editarProducto(@PathVariable int idProducto,Model model) {
			Optional<Productos>productos=service.BuscarPorIdProducto(idProducto);
			
			List<Categorias> listadoCategorias=categoriasService.BuscarTodosCategorias();
			List<Proveedores> listadoProveedores = proveedorService.BuscarTodosProveedores();
			
			model.addAttribute("productos", productos);
			model.addAttribute("lstCategorias", listadoCategorias);
			model.addAttribute("lstProveedores", listadoProveedores);
			
			
			return "crearProducto";
		}
		
		//Para ir a eliminar el registro
		@GetMapping("eliminarProducto/{idProducto}")
		public String eliminarProducto(Model model,@PathVariable int idProducto) {
			service.eliminarProducto(idProducto);
			return "redirect:/listarProductos";
		}
}
