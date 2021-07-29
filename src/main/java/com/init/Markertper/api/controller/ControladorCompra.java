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

import com.init.Markertper.api.interfacesservice.ICompraService;
import com.init.Markertper.api.interfacesservice.IProveedoresService;
import com.init.Markertper.api.interfacesservice.ITiendaService;
import com.init.Markertper.api.interfacesservice.IUsuarioService;
import com.init.Markertper.api.modelo.Compra;
import com.init.Markertper.api.modelo.Proveedores;
import com.init.Markertper.api.modelo.Tienda;
import com.init.Markertper.api.modelo.Usuario;

@Controller
@RequestMapping
public class ControladorCompra {
	
	@Autowired
	private ICompraService service;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IProveedoresService proveedoresService;
	
	@Autowired
	private ITiendaService tiendaService;
	
	
	//Para ir a la lista de todo los registros
	@RequestMapping(value = "listarCompra",method = RequestMethod.GET)
	public String listarCompra(Model model) {
		List<Compra>compra=service.BuscarTodosCompra();
		model.addAttribute("compra", compra);
		return "verCompra";
	}
			
	//Para ir a crear nuevo registro con FK
	@RequestMapping(value = "/crearCompra", method = RequestMethod.GET)
	public String crearCompra(Model model) {
		Compra compra =new Compra();
		
		List<Usuario> listadoUsuario=usuarioService.BuscarTodosUsuario();		
		List<Proveedores> listadoProveedores=proveedoresService.BuscarTodosProveedores();		
		List<Tienda> listadoTienda=tiendaService.BuscarTodosTienda();		
		
		model.addAttribute("compra", compra);
		model.addAttribute("lstUsuario", listadoUsuario);
		model.addAttribute("lstProveedores", listadoProveedores);
		model.addAttribute("lstTienda", listadoTienda);
		
		return "crearCompra";
	}
	
	//Para guardar el nuevo registro y ir a listar
	@PostMapping("guardarCompra")
	public String guardarCompra(@ModelAttribute Compra c,Model model) {
		service.guardarCompra(c);
		return "redirect:/listarCompra";
	}
	
	//Para ir a editar el registro
	@GetMapping("editarCompra/{idCompra}")
	public String editarCompra(@PathVariable int idCompra,Model model) {
		Optional<Compra>compra=service.BuscarPorIdCompra(idCompra);
		
		List<Usuario> listadoUsuario=usuarioService.BuscarTodosUsuario();		
		List<Proveedores> listadoProveedores=proveedoresService.BuscarTodosProveedores();		
		List<Tienda> listadoTienda=tiendaService.BuscarTodosTienda();		
		
		model.addAttribute("compra", compra);
		model.addAttribute("lstUsuario", listadoUsuario);
		model.addAttribute("lstProveedores", listadoProveedores);
		model.addAttribute("lstTienda", listadoTienda);
		
		return "crearCompra";
	}
	
	//Para ir a eliminar el registro
	@GetMapping("eliminarCompra/{idCompra}")
	public String eliminarCompra(Model model,@PathVariable int idCompra) {
		service.eliminarCompra(idCompra);
		return "redirect:/listarCompra";
	}
	
}
