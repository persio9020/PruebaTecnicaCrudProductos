package com.comercialcard.productos.pruebatecnicacrudproductos.infrastructure.controllers;

import com.comercialcard.productos.pruebatecnicacrudproductos.application.services.ProductService;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoRequest;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.models.dto.ProductoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Tag(name = "Produto", description = "Api de productos")
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
            summary = "Crea productos",
            description = "Creación de productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa")
    })
    @PostMapping
    public ResponseEntity<ProductoResponse> createProduct(@RequestBody ProductoRequest productoRequest) {
        ProductoResponse createdProducto = productService.createProduct(productoRequest);
        return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Obtiene el producto por id",
            description = "Obtiene el producto por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> getProductById(@PathVariable Long id) {
        log.info("Iniciando el product con id: {}", id);
        return productService.retrieveById(Long.parseLong(id.toString())).map(productoDTO -> new ResponseEntity<>(productoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @Operation(
            summary = "Obtiene todos los productos",
            description = "Obtiene todos los productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa")
    })
    @GetMapping
    public ResponseEntity<List<ProductoResponse>> getAllProducts() {
        List<ProductoResponse> allProducts = productService.retrieveAll();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @Operation(
            summary = "Retorna un listado con las combinaciones de nombres",
            description = "retorne un listado con las combinaciones de nombres de \n" +
                    "productos cuya suma de precios sea menor o igual al valor ingresado, e incluir el valor de dicha suma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa")
    })
    @GetMapping("/get-combinations")
    public ResponseEntity<List<List<Object>>> getCombinations(@RequestParam(required = true) Double value) {
        List<ProductoResponse> products = productService.retrieveAll();
        List<List<Object>> result = new ArrayList<>();
        int n = products.size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double sum2 = products.get(i).getPrecio() + products.get(j).getPrecio();
                if (sum2 <= value && i != j) {
                    if (!result.contains(Arrays.asList(products.get(j).getNombre(), products.get(i).getNombre(), sum2))) {
                        result.add(Arrays.asList(products.get(i).getNombre(), products.get(j).getNombre(), sum2));
                    }
                }
                for (int k = 0; k < n; k++) {
                    double sum3 = sum2 + products.get(k).getPrecio();
                    if (sum3 <= value && i != j && j != k && i != k) {
                        if (!result.contains(Arrays.asList(products.get(i).getNombre(), products.get(k).getNombre(), products.get(j).getNombre(), sum3)) &&
                                !result.contains(Arrays.asList(products.get(k).getNombre(), products.get(j).getNombre(), products.get(i).getNombre(), sum3))) {
                            result.add(Arrays.asList(products.get(i).getNombre(), products.get(j).getNombre(), products.get(k).getNombre(), sum3));
                        }
                    }
                }
            }
        }

        //Ordena por la suma de los precios y ordena descendente
        result.sort((a, b) -> Double.compare((Double) b.get(b.size() - 1), (Double) a.get(a.size() - 1)));
        //limita los resultados a 5
        int maxElement = 5;
        List<List<Object>> response = result.size() > maxElement ? result.subList(0, maxElement) : result;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Actualiza el producto por Id",
            description = "Actualización el producto por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa")
    })
    @PutMapping
    public ResponseEntity<ProductoResponse> updateProduct(@RequestBody ProductoRequest productoRequest) {
        return productService.updateProduct(productoRequest)
                .map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(
            summary = "Elimina el producto por Id",
            description = "Elimina el producto por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        if (productService.deleteProduct(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
