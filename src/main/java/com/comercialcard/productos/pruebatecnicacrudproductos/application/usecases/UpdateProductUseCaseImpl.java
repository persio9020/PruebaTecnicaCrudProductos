package com.comercialcard.productos.pruebatecnicacrudproductos.application.usecases;

import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoRequest;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoResponse;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.in.UpdateProductUseCase;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.out.ProductRepositoryPort;

import java.util.Optional;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public UpdateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Optional<ProductoResponse> updateProduct(ProductoRequest productoRequest) {
        return this.productRepositoryPort.update(productoRequest);
    }
}
