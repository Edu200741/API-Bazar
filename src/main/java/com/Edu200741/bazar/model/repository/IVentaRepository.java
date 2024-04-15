
package com.Edu200741.bazar.model.repository;

import com.Edu200741.bazar.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long>{
    
}
