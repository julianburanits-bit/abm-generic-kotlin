package com.julianburanits.abmgenerickotlin.domain.service

import com.julianburanits.abmgenerickotlin.domain.model.Entity
import com.julianburanits.abmgenerickotlin.domain.port.CrudRepository

/**
 * Generic application service that implements common CRUD logic.
 * It remains independent of any persistence framework.
 */
class GenericCrudService<T : Entity<ID>, ID>(
    private val repository: CrudRepository<T, ID>
) {

    fun findById(id: ID): T? = repository.findById(id)

    fun findAll(): List<T> = repository.findAll()

    fun save(entity: T): T {
        // Common validations, domain events, etc. could be added here
        return repository.save(entity)
    }

    fun deleteById(id: ID) {
        // Existence checks or domain exceptions could be added here
        repository.deleteById(id)
    }
}