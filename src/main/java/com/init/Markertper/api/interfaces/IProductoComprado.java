package com.init.Markertper.api.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.init.Markertper.api.modelo.ProductoComprado;

public interface IProductoComprado  extends CrudRepository<ProductoComprado, Integer> {

}
