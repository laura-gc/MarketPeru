package com.init.Markertper.api.modelo;

public class ProductoParaComprar  extends Productos {

	 private Float cantidad;

	    public ProductoParaComprar(String nombre, String codigo, Float precio, Float existencia, Integer id) {
		super(nombre, codigo, precio, existencia, id);
	}

		public ProductoParaComprar() {
		super();
	}

		public ProductoParaComprar(String nombre, String codigo, Float precio, Float existencia, Integer id, Float cantidad) {
	        super(nombre, codigo, precio, existencia, id);
	        this.cantidad = cantidad;
	    }

	    public ProductoParaComprar(String nombre, String codigo, Float precio, Float existencia, Float cantidad) {
	        super(nombre, codigo, precio, existencia);
	        this.cantidad = cantidad;
	    }

	   /* public void aumentarCantidad() {
	        this.cantidad++;
	    }*/

	    public Float getCantidad() {
	        return cantidad;
	    }

	    public void setCantidad(Float cantidad) {
			this.cantidad = cantidad;
		}

		public Float getTotal() {
	        return this.getPrecio() * this.cantidad;
	    }
}
