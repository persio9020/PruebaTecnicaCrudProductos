package com.comercialcard.productos.pruebatecnicacrudproductos.application.services;

import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoRequest;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoResponse;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.in.CreateProductUseCase;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.in.DeleteProductUseCase;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.in.RetrieveProductUseCase;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.in.UpdateProductUseCase;

import java.util.List;
import java.util.Optional;

public class ProductService implements CreateProductUseCase, RetrieveProductUseCase, DeleteProductUseCase, UpdateProductUseCase {

    private final CreateProductUseCase createProductUseCase;;
    private final RetrieveProductUseCase retrieveProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    public ProductService(CreateProductUseCase createProductUseCase, RetrieveProductUseCase retrieveProductUseCase, UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.retrieveProductUseCase = retrieveProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @Override
    public ProductoResponse createProduct(ProductoRequest productoRequest) {
        return this.createProductUseCase.createProduct(productoRequest);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return this.deleteProductUseCase.deleteProduct(id);
    }

    @Override
    public Optional<ProductoResponse> retrieveById(Long id) {
        return this.retrieveProductUseCase.retrieveById(id);
    }

    @Override
    public List<ProductoResponse> retrieveAll() {
        return this.retrieveProductUseCase.retrieveAll();
    }

    @Override
    public Optional<ProductoResponse> updateProduct(ProductoRequest productoRequest) {
        return this.updateProductUseCase.updateProduct(productoRequest);
    }
}
