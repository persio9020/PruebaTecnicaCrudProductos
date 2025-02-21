package com.comercialcard.productos.pruebatecnicacrudproductos.application.usecases;

import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoRequest;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoResponse;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.in.CreateProductUseCase;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.out.ProductRepositoryPort;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public CreateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public ProductoResponse createProduct(ProductoRequest productoRequest) {
        return productRepositoryPort.save(productoRequest);
    }
}
