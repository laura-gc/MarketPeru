package com.init.Markertper.api.modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdUsuario;
	
	private String Nombres;
	private String Apellidos;
	private String Correo;
	private String Usuario;
	private String Clave;
	private String Tipo_Documento;

	
	@ManyToOne
	@JoinColumn(name = "idTienda")
	private Tienda tienda;
	
	private Date FechaRegistro;

	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	public String getTipo_Documento() {
		return Tipo_Documento;
	}

	public void setTipo_Documento(String tipo_Documento) {
		Tipo_Documento = tipo_Documento;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

	public Usuario() {
		super();
	}

	public Usuario(int idUsuario, String nombres, String apellidos, String correo, String usuario, String clave,
			String tipo_Documento, Tienda tienda, Date fechaRegistro) {
		super();
		IdUsuario = idUsuario;
		Nombres = nombres;
		Apellidos = apellidos;
		Correo = correo;
		Usuario = usuario;
		Clave = clave;
		Tipo_Documento = tipo_Documento;
		this.tienda = tienda;
		FechaRegistro = fechaRegistro;
	}

	
}
