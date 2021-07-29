package com.init.Markertper.api.modelo;

import java.util.Set;

import javax.persistence.*;

import com.init.Markertper.api.util.Hora;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCompra;

	private String fechaYHora;
	
	 @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
	    private Set<ProductoComprado> productos;
	
	public int getIdCompra() {
		return IdCompra;
	}
	public void setIdCompra(int idCompra) {
		IdCompra = idCompra;
	}
	
    
    public Compra() {
        this.fechaYHora = Hora.obtenerFechaYHoraActual();
    } 

    public Integer getId() {
        return IdCompra;
    }

    public void setId(Integer id) {
        this.IdCompra = id;
    }

    public Float getTotal() {
        Float total = 0f;
        for (ProductoComprado productoVendido : this.productos) {
            total += productoVendido.getTotal();
        }
        return total;
    }

    public String getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(String fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Set<ProductoComprado> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductoComprado> productos) {
        this.productos = productos;
    }
	
	
}
