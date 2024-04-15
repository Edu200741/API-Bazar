
package com.Edu200741.bazar.controller;

import com.Edu200741.bazar.controller.dto.VentaMasAltaDTO;
import com.Edu200741.bazar.model.Producto;
import com.Edu200741.bazar.model.Venta;
import com.Edu200741.bazar.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    IVentaService ventaServ;
    
    @PostMapping("/venta/crear")
    public String saveVenta(@RequestBody Venta venta){
        ventaServ.saveVenta(venta);
        return "La venta se guardo correctamente";
    }
    
    @DeleteMapping("/venta/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        ventaServ.deleteVenta(codigo_venta);
        return "La venta se elimino correcamente";
    }
    
    @PutMapping("/venta/editar")
    public String editVenta(@RequestBody Venta venta){
        ventaServ.editVenta(venta);
        return "La venta se edito correctamente";
    }
    
    @GetMapping("/ventas")
    public List<Venta> getVenta(){
        return ventaServ.getVentas();
    }
    
    @GetMapping("/venta/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta){
        return ventaServ.findVenta(codigo_venta);
    }
    
    @GetMapping("/venta/productos/{codigo_venta}")
    public List<Producto> productosVenta(@PathVariable Long codigo_venta){
        return ventaServ.productosVenta(codigo_venta);
    }
    
    @GetMapping("/venta/fecha/{fecha_venta}")
    public String fechaVenta(@PathVariable LocalDate fecha_venta){
        return ventaServ.fechaVenta(fecha_venta);
    }
    
    @GetMapping("/venta/mayor_venta")
    public VentaMasAltaDTO ventaMasAlta(){
        return ventaServ.ventaMasAlta();
    }
    
    
    
    
}
