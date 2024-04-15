
package com.Edu200741.bazar.service;

import com.Edu200741.bazar.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    public void saveCliente(Cliente cliente);
    
    public void deleteCliente(Long id_cliente);
    
    public void editCliente(Cliente cliente);
    
    public List<Cliente> getClientes();
    
    public Cliente findCliente(Long id_cliente);
}
