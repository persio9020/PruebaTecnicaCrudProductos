package com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.in;

import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoRequest;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoResponse;

import java.util.Optional;

public interface UpdateProductUseCase {
    Optional<ProductoResponse> updateProduct(ProductoRequest productoRequest);
}
