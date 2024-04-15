
package com.Edu200741.bazar.controller;

import com.Edu200741.bazar.model.Cliente;
import com.Edu200741.bazar.service.IClienteService;
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
public class ClienteController {
    
    @Autowired
    IClienteService clienteServ;
    
    @PostMapping("/cliente/crear")
    public void saveCliente(@RequestBody Cliente cliente){
        clienteServ.saveCliente(cliente);
    }
    
    @DeleteMapping("/cliente/eliminar/{id_cliente}")
    public void deleteCliente(@PathVariable Long id_cliente){
        clienteServ.deleteCliente(id_cliente);
    }
    
    @PutMapping("/cliente/editar")
    public void editCliente(@RequestBody Cliente cliente){
        clienteServ.editCliente(cliente);
    }
    
    @GetMapping("/clientes")
    public List<Cliente> getCliente(){
        return clienteServ.getClientes();
    }
    
    @GetMapping("/cliente/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente){
        return clienteServ.findCliente(id_cliente);
    }
    
    
    
    
}
