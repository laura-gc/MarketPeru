package com.init.Markertper.api.modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categorias")
public class Categorias {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCategoria;	
	private String Descripcion;
	private Date FechaRegistro;
	
	public int getIdCategoria() {
		return IdCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Date getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	
	public Categorias() {
		super();
	}
	public Categorias(int idCategoria, String descripcion, Date fechaRegistro) {
		super();
		IdCategoria = idCategoria;
		Descripcion = descripcion;
		FechaRegistro = fechaRegistro;
	}
	
	
}
