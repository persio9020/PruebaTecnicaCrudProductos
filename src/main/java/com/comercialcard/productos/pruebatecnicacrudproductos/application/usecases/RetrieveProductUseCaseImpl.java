package com.comercialcard.productos.pruebatecnicacrudproductos.application.usecases;

import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoResponse;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.in.RetrieveProductUseCase;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.out.ProductRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveProductUseCaseImpl implements RetrieveProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public RetrieveProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Optional<ProductoResponse> retrieveById(Long id) {
        return this.productRepositoryPort.findById(id);
    }

    @Override
    public List<ProductoResponse> retrieveAll() {
        return this.productRepositoryPort.findAll();
    }
}
