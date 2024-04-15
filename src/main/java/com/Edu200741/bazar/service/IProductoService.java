
package com.Edu200741.bazar.service;

import com.Edu200741.bazar.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public void saveProducto(Producto producto);
    
    public void deleteProducto(Long codigo_producto);
    
    public void editProducto(Producto producto);
    
    public List<Producto> getProductos();
    
    public Producto findProducto(Long codigo_producto);
    
    public List<Producto> faltaStock();
}
