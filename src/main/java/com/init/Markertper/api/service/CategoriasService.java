package com.init.Markertper.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.Markertper.api.interfaces.ICategorias;
import com.init.Markertper.api.interfacesservice.ICategoriasService;
import com.init.Markertper.api.modelo.Categorias;

@Service
public class CategoriasService implements ICategoriasService{

	@Autowired//Permite inyectar una dependencia con otra
	private ICategorias data;
	
	@Override
	public List<Categorias> BuscarTodosCategorias() {
		// TODO Auto-generated method stub
		return (List<Categorias>)data.findAll();
	}

	@Override
	public Optional<Categorias> BuscarPorIdCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		return data.findById(idCategoria);
	}
	
	//Guardar un nuevo registro
	@Override
	public int guardarCategoria(Categorias c) {
		int rs=0;
		Categorias categoria=data.save(c);
		if (categoria.equals(null)) {
			rs=1;
		}
		return rs;
	}
	
	@Override
	public void eliminarCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		data.deleteById(idCategoria);
	}

}
