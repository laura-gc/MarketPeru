package com.init.Markertper.api.interfacesservice;

import java.util.List;
import java.util.Optional;

import com.init.Markertper.api.modelo.Compra;

public interface ICompraService {
	public List<Compra>BuscarTodosCompra();
	public Optional<Compra>BuscarPorIdCompra(int idCompra);
	public int guardarCompra(Compra c);
	public void eliminarCompra(int idCompra);
}
