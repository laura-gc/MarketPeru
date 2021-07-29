package com.init.Markertper.api.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.init.Markertper.api.modelo.Productos;

public interface IProductos extends CrudRepository<Productos, Integer>{

	 Productos findFirstByCodigo(String codigo);
}
