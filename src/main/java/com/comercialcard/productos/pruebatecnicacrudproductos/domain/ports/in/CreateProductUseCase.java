package com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.in;

import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoRequest;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoResponse;

public interface CreateProductUseCase {

    ProductoResponse createProduct(ProductoRequest productoRequest);
}
