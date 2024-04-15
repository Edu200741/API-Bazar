
package com.Edu200741.bazar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;
    @ManyToOne//(mappedBy="listaproductos")
    @JoinColumn(name="codigo_venta")//,referencedColumnName="codigo_venta")
    @JsonIgnore
    private Venta venta;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible, Venta venta) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
        this.venta = venta;
    }

    

    

  

   
    
    
}
