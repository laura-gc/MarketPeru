package com.init.Markertper.api.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.init.Markertper.api.interfaces.ICompra;
import com.init.Markertper.api.interfaces.IProductoComprado;
import com.init.Markertper.api.interfaces.IProductos;
import com.init.Markertper.api.modelo.Compra;
import com.init.Markertper.api.modelo.ProductoComprado;
import com.init.Markertper.api.modelo.ProductoParaComprar;
import com.init.Markertper.api.modelo.Productos;

@Controller
@RequestMapping
public class ControladorProductoCompra {

	@Autowired
	private IProductos data;
	
	@Autowired 
	private ICompra compradata;
	
	@Autowired
	private IProductoComprado pcdata;
	
		private ArrayList<ProductoParaComprar> obtenerCarrito(HttpServletRequest request) {
	    
			ArrayList<ProductoParaComprar> carrito = (ArrayList<ProductoParaComprar>) request.getSession().getAttribute("carrito");
		    if (carrito == null) {
		        carrito = new ArrayList<>();
		    }
		    return carrito;
		}

		private void guardarCarrito(ArrayList<ProductoParaComprar> carrito, HttpServletRequest request) {
		    request.getSession().setAttribute("carrito", carrito);
		}
	
	@GetMapping(value = "/compra")
	public String interfazCompra(Model model, HttpServletRequest request) {
	    model.addAttribute("producto", new ProductoParaComprar());
	    float total = 0;
	    ArrayList<ProductoParaComprar> carrito = this.obtenerCarrito(request);
	    for (ProductoParaComprar p: carrito) total += p.getTotal();
	    model.addAttribute("total", total);
	    return "Comprar";
	}
	 
	@PostMapping(value = "/agregar")
	public String agregarAlCarrito(@ModelAttribute ProductoParaComprar producto, Float cantidad,HttpServletRequest request, RedirectAttributes redirectAttrs) {
	    
		ArrayList<ProductoParaComprar> carrito = this.obtenerCarrito(request);
	    Productos productoBuscadoPorCodigo = data.findFirstByCodigo(producto.getNombre());
	    if (productoBuscadoPorCodigo == null) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "El producto con ese nombre " + producto.getCodigo() + " no existe")
	                .addFlashAttribute("clase", "warning");
	        return "redirect:/compra";
	    }
	    if (productoBuscadoPorCodigo.sinExistencia()) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "El producto está agotado")
	                .addFlashAttribute("clase", "warning");
	        return "redirect:/compra";
	    }
	    boolean encontrado = false;
	    for (ProductoParaComprar productoParaVenderActual : carrito) {
	        if (productoParaVenderActual.getNombre().equals(productoBuscadoPorCodigo.getNombre())) {
	            productoParaVenderActual.setCantidad(cantidad);
	            encontrado = true;
	            break;
	        }
	    }
	    if (!encontrado) {
	        carrito.add(new ProductoParaComprar(productoBuscadoPorCodigo.getNombre(), productoBuscadoPorCodigo.getCodigo(), productoBuscadoPorCodigo.getPrecio(), productoBuscadoPorCodigo.getExistencia(), productoBuscadoPorCodigo.getIdProducto(), cantidad));
	    }
	    this.guardarCarrito(carrito, request);
	    return "redirect:/compra";
	}
	
	@PostMapping(value = "/quitar/{indice}")
	public String quitarDelCarrito(@PathVariable int indice, HttpServletRequest request) {
	    ArrayList<ProductoParaComprar> carrito = this.obtenerCarrito(request);
	    if (carrito != null && carrito.size() > 0 && carrito.get(indice) != null) {
	        carrito.remove(indice);
	        this.guardarCarrito(carrito, request);
	    }
	    return "redirect:/compra";
	}
	
	private void limpiarCarrito(HttpServletRequest request) {
	    this.guardarCarrito(new ArrayList<>(), request);
	}

	@GetMapping(value = "/limpiar")
	public String cancelarCompra(HttpServletRequest request, RedirectAttributes redirectAttrs) {
	    this.limpiarCarrito(request);
	    redirectAttrs
	            .addFlashAttribute("mensaje", "Compra cancelada")
	            .addFlashAttribute("clase", "info");
	    return "redirect:/listarCompra";
	}
	
	@PostMapping(value = "/terminar")
	public String terminarCompra(HttpServletRequest request, RedirectAttributes redirectAttrs) {
	    ArrayList<ProductoParaComprar> carrito = this.obtenerCarrito(request);
	    
	    if (carrito == null || carrito.size() <= 0) {
	        return "redirect:/listarCompra";
	    }
	    Compra v = compradata.save(new Compra());
	  
	    for (ProductoParaComprar productoParaComprar : carrito) {
	        
	        Productos p = data.findById(productoParaComprar.getIdProducto()).orElse(null);
	        if (p == null) continue; // Si es nulo o no existe, ignoramos el siguiente código con continue
	        // Le restamos existencia
	        p.sumarExistencia(productoParaComprar.getCantidad());
	        // Lo guardamos con la existencia ya restada
	        data.save(p);
	        // Creamos un nuevo producto que será el que se guarda junto con la venta
	        ProductoComprado productoComprado = new ProductoComprado(productoParaComprar.getCantidad(), productoParaComprar.getPrecio(), productoParaComprar.getNombre(), productoParaComprar.getCodigo(), v);
	        // Y lo guardamos
	        pcdata.save(productoComprado);
	    }

	    // Al final limpiamos el carrito
	    this.limpiarCarrito(request);
	    // e indicamos una venta exitosa
	    redirectAttrs
	            .addFlashAttribute("mensaje", "Compra realizada correctamente")
	            .addFlashAttribute("clase", "success");
	    return "redirect:/listarCompra";
	} 
}


