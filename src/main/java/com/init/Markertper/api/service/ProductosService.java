package com.init.Markertper.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.Markertper.api.interfaces.IProductos;
import com.init.Markertper.api.interfacesservice.IProductosService;
import com.init.Markertper.api.modelo.Productos;

@Service
public class ProductosService implements IProductosService{


	@Autowired//Permite inyectar una dependencia con otra
	private IProductos data;
	
	@Override
	public List<Productos> BuscarTodosProductos() {
		// TODO Auto-generated method stub
		return (List<Productos>)data.findAll();
	}

	@Override
	public Optional<Productos> BuscarPorIdProducto(int idProducto) {
		// TODO Auto-generated method stub
		return data.findById(idProducto);
	}

	@Override
	public int guardarProducto(Productos p) {
		
		p.setCodigo(p.getNombre());
		
		int rs=0;
		Productos productos=data.save(p);
		if (productos.equals(null)) {
			rs=1;
		}
		return rs;
	}

	@Override
	public void eliminarProducto(int idProducto) {
		// TODO Auto-generated method stub
		data.deleteById(idProducto);
	}
}
