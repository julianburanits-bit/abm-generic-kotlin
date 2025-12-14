package com.julianburanits.abmgenerickotlin.infrastructure.persistence

import com.julianburanits.abmgenerickotlin.domain.example.Product
import com.julianburanits.abmgenerickotlin.domain.port.CrudRepository
import org.springframework.stereotype.Repository

/**
 * In-memory implementation of CrudRepository for Product.
 * Useful for testing and demonstration without a real database.
 */
@Repository
class InMemoryProductRepository : CrudRepository<Product, Long> {

    private val storage: MutableMap<Long, Product> = mutableMapOf()
    private var sequence: Long = 1L

    override fun findById(id: Long): Product? = storage[id]

    override fun findAll(): List<Product> = storage.values.toList()

    override fun save(entity: Product): Product {
        val productToSave = if (entity.id == null) {
            entity.copy(id = sequence++)
        } else {
            entity
        }
        storage[productToSave.id!!] = productToSave
        return productToSave
    }

    override fun deleteById(id: Long) {
        storage.remove(id)
    }
}