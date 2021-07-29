package com.init.Markertper.api.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.init.Markertper.api.interfacesservice.IProveedoresService;
import com.init.Markertper.api.modelo.Proveedores;


@Controller 
@RequestMapping
public class ControladorProveedores {
	
	@Autowired
	private IProveedoresService service;
	
	//Para ir a la lista de todo los registros
	@RequestMapping(value = "listarProveedor",method = RequestMethod.GET)
	public String listarProveedor(Model model) {
		List<Proveedores>proveedores=service.BuscarTodosProveedores();
		model.addAttribute("proveedores", proveedores);
		return "listarProveedor";
	}
	
	//Para ir a crear nuevo registro
	@RequestMapping(value = "crearProveedor",method = RequestMethod.GET)
	public String crearProveedor(Model model) {
		model.addAttribute("proveedor", new  Proveedores());
		return "crearProveedor";
	}
	
	//Para guardar el nuevo registro y ir a listar
	@PostMapping("guardarProveedor")
	public String guardarProveedor(@ModelAttribute Proveedores proveedores ,@RequestParam("file") MultipartFile imagen) {
				
		if(!imagen.isEmpty()) {
			
			Path directorioImagenes = Paths.get("src//main//resources//static/imgProveedor");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+ imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
								
				proveedores.setFoto(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			
		}
		service.guardarProveedor(proveedores);
		return "redirect:/listarProveedor";
	}
	
	//Para ir a editar el registro
	@GetMapping("editarProveedor/{idProveedor}")
	public String editarProveedor(@PathVariable int idProveedor,Model model) {
		Optional<Proveedores>proveedor=service.BuscarPorIdProveedor(idProveedor);
		model.addAttribute("proveedor", proveedor);
		return "crearProveedor";
	}
	
	//Para ir a eliminar el registro
	@GetMapping("eliminarProveedor/{idProveedor}")
	public String eliminarProveedor(Model model,@PathVariable int idProveedor) {
		service.eliminarProveedor(idProveedor);
		return "redirect:/listarProveedor";
	}
	
	/*---------------------------------------*/
	//Para ir a Inicio
	@RequestMapping(value = "Inicio",method = RequestMethod.GET)
	public String Inicio() {
		return "Inicio";
	}
	
	//Para ir al Encabezado
	@RequestMapping(value = "Encabezado",method = RequestMethod.GET)
	public String Encabezado() {
		return "Encabezado";
	}
	
	//Para ir al EncabezadoBootsrap
		@RequestMapping(value = "EncabezadoBootsrap",method = RequestMethod.GET)
		public String EncabezadoBootsrap() {
			return "EncabezadoBootsrap";
		}
}
