package com.comercialcard.productos.pruebatecnicacrudproductos.infrastructure.repositories;

import com.comercialcard.productos.pruebatecnicacrudproductos.infrastructure.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductoRepository extends JpaRepository<Producto, Long> {
}
