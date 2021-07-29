package com.init.Markertper.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.Markertper.api.interfaces.ITienda;
import com.init.Markertper.api.interfacesservice.ITiendaService;
import com.init.Markertper.api.modelo.Tienda;

@Service
public class TiendaService implements ITiendaService{

	@Autowired//Permite inyectar una dependencia con otra
	private ITienda data;
	
	@Override
	public List<Tienda> BuscarTodosTienda() {
		// TODO Auto-generated method stub
		return (List<Tienda>)data.findAll();
	}

	@Override
	public Optional<Tienda> BuscarPorIdTienda(int idTienda) {
		// TODO Auto-generated method stub
		return data.findById(idTienda);
	}

	@Override
	public int guardarTienda(Tienda t) {
		int rs=0;
		Tienda tienda=data.save(t);
		if (tienda.equals(null)) {
			rs=1;
		}
		return rs;
	}

	@Override
	public void eliminarTienda(int idTienda) {
		data.deleteById(idTienda);
	}

}
