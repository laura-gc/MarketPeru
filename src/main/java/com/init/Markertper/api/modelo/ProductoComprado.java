package com.init.Markertper.api.modelo;

import javax.persistence.*;

@Entity
public class ProductoComprado {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
	    private Float cantidad, precio;
	    private String nombre, codigo;
	    
	    @ManyToOne
	    @JoinColumn
	    private Compra compra;

	    public ProductoComprado(Float cantidad, Float precio, String nombre, String codigo, Compra compra) {
	        this.cantidad = cantidad;
	        this.precio = precio;
	        this.nombre = nombre;
	        this.codigo = codigo;
	        this.compra = compra;
	    }

	    public ProductoComprado() {
	    }

	    public Float getTotal() {
	        return this.cantidad * this.precio;
	    }

	    public Compra getCompra() {
	        return compra;
	    }

	    public void setVenta(Compra compra) {
	        this.compra = compra;
	    }

	    public Float getPrecio() {
	        return precio;
	    }

	    public void setPrecio(Float precio) {
	        this.precio = precio;
	    }

	    public Float getCantidad() {
	        return cantidad;
	    }

	    public void setCantidad(Float cantidad) {
	        this.cantidad = cantidad;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(String codigo) {
	        this.codigo = codigo;
	    }
}
