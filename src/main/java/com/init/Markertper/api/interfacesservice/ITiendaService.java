package com.init.Markertper.api.interfacesservice;

import java.util.List;
import java.util.Optional;

import com.init.Markertper.api.modelo.Tienda;

public interface ITiendaService {
	public List<Tienda>BuscarTodosTienda();
	public Optional<Tienda>BuscarPorIdTienda(int idTienda);
	public int guardarTienda(Tienda t);
	public void eliminarTienda(int idTienda);
}
