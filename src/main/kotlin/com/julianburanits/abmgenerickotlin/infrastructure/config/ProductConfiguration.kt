package com.julianburanits.abmgenerickotlin.infrastructure.config

import com.julianburanits.abmgenerickotlin.domain.example.Product
import com.julianburanits.abmgenerickotlin.domain.service.GenericCrudService
import com.julianburanits.abmgenerickotlin.infrastructure.persistence.InMemoryProductRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Configuration that exposes a GenericCrudService bean specifically for Product.
 */
@Configuration
class ProductConfiguration {

    @Bean
    fun productCrudService(repository: InMemoryProductRepository): GenericCrudService<Product, Long> {
        return GenericCrudService(repository)
    }
}