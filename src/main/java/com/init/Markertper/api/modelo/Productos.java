package com.init.Markertper.api.modelo;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;	
	
	private String Nombre;
	private String Descripcion;
	
	//Notación que permite definir una relación de muchos a uno
	@ManyToOne	
	//Nombre del atributo que define la relacion
	@JoinColumn(name = "idCategoria")
	private Categorias categorias;
	
	@ManyToOne	
	//Nombre del atributo que define la relacion
	@JoinColumn(name = "IdProveedor")
	private Proveedores proveedores;
	
	private Date FechaRegistro;
	
	 @NotNull(message = "Debes especificar el precio")
	 @Min(value = 0, message = "El precio mínimo es 0")
	 private Float precio;

	 @NotNull(message = "Debes especificar la existencia")
	 @Min(value = 0, message = "La existencia mínima es 0")
	 private Float existencia;
	 
	 @NotNull(message = "Debes especificar el código")
	 @Size(min = 1, max = 50, message = "El código debe medir entre 1 y 50")
	 private String codigo;

	public int getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	 public String getCodigo() {
	        return codigo;
	 }

	 public void setCodigo(String codigo) {
	        this.codigo = codigo;
	 }
	    
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	
	 public Float getPrecio() {
	        return precio;
	    }

	 public void setPrecio(Float precio) {
	        this.precio = precio;
	 }

	 public Float getExistencia() {
	        return existencia;
	 }
	 
	public boolean sinExistencia() {
        return this.existencia <= 0;
    }
	
	public void setExistencia(Float existencia) {
	        this.existencia = existencia;
    }

	public void sumarExistencia(Float existencia) {
	        this.existencia += existencia;
	}
	
	public Productos(String nombre, String codigo, Float precio, Float existencia, Integer id) {
        this.Nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.existencia = existencia;
        this.idProducto = id;
    }

    public Productos(String nombre, String codigo, Float precio, Float existencia) {
        this.Nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.existencia = existencia;
    }

    public Productos(@NotNull(message = "Debes especificar el código") @Size(min = 1, max = 50, message = "El código debe medir entre 1 y 50") String codigo) {
        this.codigo = codigo;
    }

    public Productos() {
    }

	public Proveedores getProveedores() {
		return proveedores;
	}

	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
	}

	public Productos(int idProducto, String nombre, String descripcion, Categorias categorias, Proveedores proveedores,
			Date fechaRegistro,
			@NotNull(message = "Debes especificar el precio") @Min(value = 0, message = "El precio mínimo es 0") Float precio,
			@NotNull(message = "Debes especificar la existencia") @Min(value = 0, message = "La existencia mínima es 0") Float existencia,
			@NotNull(message = "Debes especificar el código") @Size(min = 1, max = 50, message = "El código debe medir entre 1 y 50") String codigo) {
		super();
		this.idProducto = idProducto;
		Nombre = nombre;
		Descripcion = descripcion;
		this.categorias = categorias;
		this.proveedores = proveedores;
		FechaRegistro = fechaRegistro;
		this.precio = precio;
		this.existencia = existencia;
		this.codigo = codigo;
	}
	

	
		
}
