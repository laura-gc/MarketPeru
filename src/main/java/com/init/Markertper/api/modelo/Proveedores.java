package com.init.Markertper.api.modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Proveedores")
public class Proveedores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdProveedor;
	private String Ruc;
	private String RazonSocial;
	private String Telefono;
	private String Correo;
	private String Direccion;
	private String Foto;
	private Date FechaRegistro;
	
	public int getIdProveedor() {
		return IdProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		IdProveedor = idProveedor;
	}
	public String getRuc() {
		return Ruc;
	}
	public void setRuc(String ruc) {
		Ruc = ruc;
	}
	public String getRazonSocial() {
		return RazonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getFoto() {
		return Foto;
	}
	public void setFoto(String foto) {
		Foto = foto;
	}
	public Date getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	
	////Constructor vacio
	public Proveedores() {
		super();
	}
	
	//Constructor con todos los parametros
	public Proveedores(int idProveedor, String ruc, String razonSocial, String telefono, String correo,
			String direccion, String foto, Date fechaRegistro) {
		super();
		IdProveedor = idProveedor;
		Ruc = ruc;
		RazonSocial = razonSocial;
		Telefono = telefono;
		Correo = correo;
		Direccion = direccion;
		Foto = foto;
		FechaRegistro = fechaRegistro;
	}	
	
}
