package com.julianburanits.abmgenerickotlin.infrastructure.web

import com.julianburanits.abmgenerickotlin.domain.example.Product
import com.julianburanits.abmgenerickotlin.domain.service.GenericCrudService
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

/**
 * Functional-style router configuration.
 * Registers CRUD endpoints for specific entities.
 */
@Configuration
class RouterConfiguration(private val context: ApplicationContext) {

    @Bean
    fun productRouter() = router {
        val service = context.getBean("productCrudService", GenericCrudService::class.java)
                as GenericCrudService<Product, Long>

        "/api/products".nest {
            accept(MediaType.APPLICATION_JSON).nest {
                GET {
                    ServerResponse.ok().body(service.findAll())
                }

                GET("/{id}") { req -> // TODO: this endpoint isn't working as intended, more like a findAll() instead
                    val id = req.pathVariable("id").toLong()
                    val product = service.findById(id)
                    if (product != null) {
                        ServerResponse.ok().body(product)
                    } else {
                        ServerResponse.notFound().build()
                    }
                }

                POST { req ->
                    val product = req.body(Product::class.java)
                    val saved = service.save(product)
                    ServerResponse.status(201).body(saved)
                }

                PUT("/{id}") { req ->
                    val id = req.pathVariable("id").toLong()
                    val product = req.body(Product::class.java)
                    val updated = service.save(product.copy(id = id))
                    ServerResponse.ok().body(updated)
                }

                DELETE("/{id}") { req ->
                    val id = req.pathVariable("id").toLong()
                    service.deleteById(id)
                    ServerResponse.noContent().build()
                }
            }
        }
    }
}
