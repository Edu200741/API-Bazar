
package com.Edu200741.bazar.dto;

import com.Edu200741.bazar.model.Producto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class VentaMasAltaDTO {
    
    private Long codigo_venta;
    private Double total;
    private List<Producto> listaProductos;
    private String nombre;
    private String apellido;  

    public VentaMasAltaDTO() {
    }

    public VentaMasAltaDTO(Long codigo_venta, Double total, List<Producto> listaProductos, String nombre, String apellido) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
}
