package com.init.Markertper.api.interfacesservice;

import java.util.List;
import java.util.Optional;

import com.init.Markertper.api.modelo.Proveedores;

public interface IProveedoresService {
	public List<Proveedores>BuscarTodosProveedores();
	public Optional<Proveedores>BuscarPorIdProveedor(int idProveedor);
	public int guardarProveedor(Proveedores p);
	public void eliminarProveedor(int idProveedor);
}
