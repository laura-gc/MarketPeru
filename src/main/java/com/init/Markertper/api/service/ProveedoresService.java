package com.init.Markertper.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.Markertper.api.interfaces.IProveedores;
import com.init.Markertper.api.interfacesservice.IProveedoresService;
import com.init.Markertper.api.modelo.Proveedores;

@Service
public class ProveedoresService implements IProveedoresService{

	@Autowired//Permite inyectar una dependencia con otra
	private IProveedores data;
	
	//Listar todos los registros
	@Override
	public List<Proveedores> BuscarTodosProveedores() {
		// TODO Auto-generated method stub
		return (List<Proveedores>)data.findAll();
	}

	//Buscar un registro
	@Override
	public Optional<Proveedores> BuscarPorIdProveedor(int idProveedor) {
		// TODO Auto-generated method stub
		return data.findById(idProveedor);
	}
	
	//Guardar un nuevo registro
	@Override
	public int guardarProveedor(Proveedores p) {
		int rs=0;
		Proveedores proveedor=data.save(p);
		if (proveedor.equals(null)) {
			rs=1;
		}
		return rs;
	}

	//Eliminar un registro
	@Override
	public void eliminarProveedor(int idProveedor) {
		data.deleteById(idProveedor);
	}

}
