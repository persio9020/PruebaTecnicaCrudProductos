package com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.out;

import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoRequest;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoResponse;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    ProductoResponse save(ProductoRequest productoRequest);
    Optional<ProductoResponse> findById(Long id);
    List<ProductoResponse> findAll();
    Optional<ProductoResponse> update(ProductoRequest productoRequest);
    boolean deleteById(Long id);
}
