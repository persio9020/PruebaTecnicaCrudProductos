package com.comercialcard.productos.pruebatecnicacrudproductos.infrastructure.config;

import com.comercialcard.productos.pruebatecnicacrudproductos.application.services.ProductService;
import com.comercialcard.productos.pruebatecnicacrudproductos.application.usecases.CreateProductUseCaseImpl;
import com.comercialcard.productos.pruebatecnicacrudproductos.application.usecases.DeleteProductUseCaseimpl;
import com.comercialcard.productos.pruebatecnicacrudproductos.application.usecases.RetrieveProductUseCaseImpl;
import com.comercialcard.productos.pruebatecnicacrudproductos.application.usecases.UpdateProductUseCaseImpl;
import com.comercialcard.productos.pruebatecnicacrudproductos.domain.ports.out.ProductRepositoryPort;
import com.comercialcard.productos.pruebatecnicacrudproductos.infrastructure.repositories.JpaProductRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ProductService productService(ProductRepositoryPort productRepositoryPort) {
        return new ProductService(
                new CreateProductUseCaseImpl(productRepositoryPort),
                new RetrieveProductUseCaseImpl(productRepositoryPort),
                new UpdateProductUseCaseImpl(productRepositoryPort),
                new DeleteProductUseCaseimpl(productRepositoryPort));
    }

    @Bean
    public ProductRepositoryPort productRepositoryPort(JpaProductRepositoryAdapter jpaProductoRepositoryAdapter) {
        return jpaProductoRepositoryAdapter;
    }
}
