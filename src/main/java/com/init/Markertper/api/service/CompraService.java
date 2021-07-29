package com.init.Markertper.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.Markertper.api.interfaces.ICompra;
import com.init.Markertper.api.interfacesservice.ICompraService;
import com.init.Markertper.api.modelo.Compra;

@Service
public class CompraService implements ICompraService{

	@Autowired//Permite inyectar una dependencia con otra
	private ICompra data;
	
	@Override
	public List<Compra> BuscarTodosCompra() {
		// TODO Auto-generated method stub
		return (List<Compra>)data.findAll();
	}

	@Override
	public Optional<Compra> BuscarPorIdCompra(int idCompra) {
		// TODO Auto-generated method stub
		return data.findById(idCompra);
	}

	@Override
	public int guardarCompra(Compra c) {
		// TODO Auto-generated method stub
		int rs=0;
		Compra compra=data.save(c);
		if (compra.equals(null)) {
			rs=1;
		}
		return rs;
	}

	@Override
	public void eliminarCompra(int idCompra) {
		// TODO Auto-generated method stub
		data.deleteById(idCompra);
	}

}
