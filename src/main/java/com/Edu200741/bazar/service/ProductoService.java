
package com.Edu200741.bazar.service;

import com.Edu200741.bazar.model.Producto;
import com.Edu200741.bazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    IProductoRepository productoRepo;
    
    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        productoRepo.deleteById(codigo_producto);
    }

    @Override
    public void editProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        return productoRepo.findById(codigo_producto).orElse(null);
    }

    @Override
    public List<Producto> faltaStock() {
        List<Producto> listaProductos = this.getProductos();
        List<Producto> faltantes = new ArrayList<Producto>();
        
        for (Producto produ : listaProductos){
            if(produ.getCantidad_disponible()<5){
                faltantes.add(produ);
            }
        }
        return faltantes;
    }
    
}
