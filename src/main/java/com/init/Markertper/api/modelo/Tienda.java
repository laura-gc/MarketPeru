package com.init.Markertper.api.modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tienda")
public class Tienda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdTienda;
	
	private String Nombre;
	private String Ruc;
	private String Direccion;
	private String Telefono;
	private Date FechaRegistro;
	public int getIdTienda() {
		return IdTienda;
	}
	public void setIdTienda(int idTienda) {
		IdTienda = idTienda;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getRuc() {
		return Ruc;
	}
	public void setRuc(String ruc) {
		Ruc = ruc;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public Date getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	public Tienda() {
		super();
	}
	public Tienda(int idTienda, String nombre, String ruc, String direccion, String telefono, Date fechaRegistro) {
		super();
		IdTienda = idTienda;
		Nombre = nombre;
		Ruc = ruc;
		Direccion = direccion;
		Telefono = telefono;
		FechaRegistro = fechaRegistro;
	}
	
	
}
