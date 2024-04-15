
package com.Edu200741.bazar.service;

import com.Edu200741.bazar.dto.VentaMasAltaDTO;
import com.Edu200741.bazar.model.Producto;
import com.Edu200741.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    public void saveVenta(Venta venta);
    
    public void deleteVenta(Long codigo_venta);
    
    public void editVenta(Venta venta);
    
    public List<Venta> getVentas();
    
    public Venta findVenta(Long codigo_venta);
    
    public List<Producto> productosVenta(Long codigo_venta);//
    
    public String fechaVenta(LocalDate fecha_venta);
    
    public VentaMasAltaDTO ventaMasAlta();
}
