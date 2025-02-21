package com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.in;

import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoResponse;

import java.util.List;
import java.util.Optional;

public interface RetrieveProductUseCase {

    Optional<ProductoResponse> retrieveById(Long id);

    List<ProductoResponse> retrieveAll();
}
