package com.comercialcard.productos.pruebatecnicacrudproductos.infrastructure.repositories;

import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoRequest;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoResponse;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.out.ProductRepositoryPort;
import com.comercialcard.productos.pruebatecnicacrudproductos.infrastructure.entities.Producto;
import com.comercialcard.productos.pruebatecnicacrudproductos.infrastructure.entities.mapper.ProductResponseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {

    private final JpaProductoRepository JpaProductoRepository;
    private final ProductResponseMapper productResponseMapper;

    public JpaProductRepositoryAdapter(JpaProductoRepository JpaProductoRepository, ProductResponseMapper productResponseMapper) {
        this.JpaProductoRepository = JpaProductoRepository;
        this.productResponseMapper = productResponseMapper;
    }

    @Override
    public ProductoResponse save(ProductoRequest productoRequest) {
        Producto producto = this.productResponseMapper.productoRequestToProducto(productoRequest);
        Producto saveProducto = JpaProductoRepository.save(producto);
        return this.productResponseMapper.productoToProductoResponse(saveProducto);
    }

    @Override
    public Optional<ProductoResponse> findById(Long id) {
        return JpaProductoRepository.findById(id).map(this.productResponseMapper::productoToProductoResponse);
    }

    @Override
    public List<ProductoResponse> findAll() {
        return JpaProductoRepository.findAll().stream().map(this.productResponseMapper::productoToProductoResponse).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductoResponse> update(ProductoRequest productoRequest) {
        if (JpaProductoRepository.existsById(productoRequest.getId())) {
            Producto producto = this.productResponseMapper.productoRequestToProducto(productoRequest);
            Producto saveProducto = JpaProductoRepository.save(producto);
            return Optional.of(productResponseMapper.productoToProductoResponse(saveProducto));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (JpaProductoRepository.existsById(id)) {
            JpaProductoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
