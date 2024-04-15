
package com.Edu200741.bazar.service;

import com.Edu200741.bazar.controller.dto.VentaMasAltaDTO;
//import com.Edu200741.bazar.model.Cliente;
import com.Edu200741.bazar.model.Producto;
import com.Edu200741.bazar.model.Venta;
import com.Edu200741.bazar.model.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VentaService implements IVentaService{
    
    @Autowired
    IVentaRepository ventaRepo;
    
    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public void editVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        return ventaRepo.findById(codigo_venta).orElse(null);
    }

    @Override
    public List<Producto> productosVenta(Long codigo_venta) {
        Venta venta = this.findVenta(codigo_venta);
       
        return venta.getListaProductos();
    }

    @Override
    public VentaMasAltaDTO ventaMasAlta() {
        
        VentaMasAltaDTO ventaAlta = new VentaMasAltaDTO();
        Venta ventaMax = new Venta();
        
        Double ven = 0.0;
        
        List<Venta> listaVentas = this.getVentas();
        
        for(Venta venta : listaVentas){
            if(venta.getTotal()>ven){
                ven += venta.getTotal();
                ventaMax = venta;
            }
        }
        ventaAlta.setCodigo_venta(ventaMax.getCodigo_venta());
        ventaAlta.setNombre(ventaMax.getUnCliente().getNombre());
        ventaAlta.setApellido(ventaMax.getUnCliente().getApellido());
        ventaAlta.setListaProductos(ventaMax.getListaProductos());
        ventaAlta.setTotal(ventaMax.getTotal());
        return ventaAlta;
    }

    @Override
    public String fechaVenta(LocalDate fecha_venta) {
        Double sumatoria=0.0;
        int canVenta = 0;
        List<Venta> listaVenta = this.getVentas();
        for(Venta ven : listaVenta){
            if(fecha_venta.equals(ven.getFecha_venta())){
                canVenta=canVenta + 1;
                sumatoria =+ ven.getTotal();
            }
        }
        return "La cantidad de ventas de la fecha: "+" " + fecha_venta + " es de : " + canVenta + 
                " y el total de las ventas es de: " + sumatoria;
    }
           
                
        
    
}
