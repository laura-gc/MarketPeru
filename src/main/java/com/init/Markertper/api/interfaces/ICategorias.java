package com.init.Markertper.api.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.init.Markertper.api.modelo.Categorias;

@Repository
public interface ICategorias extends CrudRepository<Categorias, Integer>{

}
