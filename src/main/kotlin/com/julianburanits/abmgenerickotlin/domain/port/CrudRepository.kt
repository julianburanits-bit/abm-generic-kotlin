package com.julianburanits.abmgenerickotlin.domain.port

import com.julianburanits.abmgenerickotlin.domain.model.Entity

/**
 * Driven port for generic CRUD operations.
 * Users of this project must implement this interface for their specific entity.
 *
 * @param T the entity type (must extend Entity<ID>)
 * @param ID the identifier type
 */
interface CrudRepository<T : Entity<ID>, ID> {

    fun findById(id: ID): T?

    fun findAll(): List<T>

    fun save(entity: T): T

    fun deleteById(id: ID)

    // Optional: additional operations like existsById, count, etc. can be added later
}