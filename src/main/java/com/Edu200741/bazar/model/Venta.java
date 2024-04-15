
package com.Edu200741.bazar.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Venta implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo_venta;
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_venta;
    private Double total;
    
    @OneToMany(mappedBy="venta",cascade = CascadeType.PERSIST)
    private List<Producto> listaProductos;
    
    @OneToOne
    @JoinColumn(name="id_cliente",referencedColumnName="id_cliente")
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }

  
    
    
}
