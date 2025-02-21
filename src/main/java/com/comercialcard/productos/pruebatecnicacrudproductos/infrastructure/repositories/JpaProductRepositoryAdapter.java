package com.comercialcard.productos.pruebatecnicacrudproductos.infrastructure.repositories;

import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoRequest;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoResponse;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.out.ProductRepositoryPort;
import com.comercialcard.productos.pruebatecnicacrudproductos.infrastructure.entities.Producto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {

    private final JpaProductoRepository JpaProductoRepository;

    public JpaProductRepositoryAdapter(JpaProductoRepository JpaProductoRepository) {
        this.JpaProductoRepository = JpaProductoRepository;
    }

    @Override
    public ProductoResponse save(ProductoRequest productoRequest) {
        Producto producto = Producto.fromDomainModel(productoRequest);
        Producto saveProducto = JpaProductoRepository.save(producto);
        return saveProducto.toDomainModel();
    }

    @Override
    public Optional<ProductoResponse> findById(Long id) {
        return JpaProductoRepository.findById(id).map(Producto::toDomainModel);
    }

    @Override
    public List<ProductoResponse> findAll() {
        return JpaProductoRepository.findAll().stream().map(Producto::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductoResponse> update(ProductoRequest productoRequest) {
        if (JpaProductoRepository.existsById(productoRequest.getId())) {
            Producto producto = Producto.fromDomainModel(productoRequest);
            Producto saveProducto = JpaProductoRepository.save(producto);
            return Optional.of(saveProducto.toDomainModel());
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
