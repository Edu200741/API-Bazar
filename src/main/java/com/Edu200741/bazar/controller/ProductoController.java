
package com.Edu200741.bazar.controller;

import com.Edu200741.bazar.model.Producto;
import com.Edu200741.bazar.service.IProductoService;
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
public class ProductoController {
    
    @Autowired
    IProductoService productoServ;
    
    @PostMapping("/producto/crear")
    public void saveProducto(@RequestBody Producto producto){
        productoServ.saveProducto(producto);
    }
    
    @DeleteMapping("/producto/eliminar/{codigo_producto}")
    public void deleteProducto(@PathVariable Long codigo_producto){
        productoServ.deleteProducto(codigo_producto);
    }
    
    @PutMapping("/producto/editar")
    public void editProducto(@RequestBody Producto producto){
        productoServ.editProducto(producto);
    }
    
    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return productoServ.getProductos();
    }
    
    @GetMapping("/producto/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
        return productoServ.findProducto(codigo_producto);
    }
    
    @GetMapping("/producto/falta_stock")
    public List<Producto> faltaStock(){
        return productoServ.faltaStock();
    }
    
}
