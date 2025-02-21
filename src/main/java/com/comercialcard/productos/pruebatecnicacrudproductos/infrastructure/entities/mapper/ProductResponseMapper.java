package com.comercialcard.productos.pruebatecnicacrudproductos.infrastructure.entities.mapper;

import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoRequest;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoResponse;
import com.comercialcard.productos.pruebatecnicacrudproductos.infrastructure.entities.Producto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {

    ProductoResponse productoToProductoResponse(Producto producto);

    Producto productoRequestToProducto(ProductoRequest productoRequest);
}
