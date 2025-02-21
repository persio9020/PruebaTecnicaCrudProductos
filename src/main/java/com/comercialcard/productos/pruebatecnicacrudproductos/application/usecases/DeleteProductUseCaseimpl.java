package com.comercialcard.productos.pruebatecnicacrudproductos.application.usecases;

import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.in.DeleteProductUseCase;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.out.ProductRepositoryPort;

public class DeleteProductUseCaseimpl implements DeleteProductUseCase {
    ProductRepositoryPort productoRespositoryPort;

    public DeleteProductUseCaseimpl(ProductRepositoryPort productoRespositoryPort) {
        this.productoRespositoryPort = productoRespositoryPort;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return this.productoRespositoryPort.deleteById(id);
    }
}
