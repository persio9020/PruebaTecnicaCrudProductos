package com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer cantidadStock;
    private Double valorTotalInventario;
}
