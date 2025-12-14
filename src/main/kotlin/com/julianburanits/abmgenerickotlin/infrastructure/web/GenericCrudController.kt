package com.julianburanits.abmgenerickotlin.infrastructure.web

import com.julianburanits.abmgenerickotlin.domain.model.Entity
import com.julianburanits.abmgenerickotlin.domain.service.GenericCrudService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Generic REST controller that exposes standard CRUD endpoints.
 * It operates on any entity type T with identifier ID, as long as a corresponding
 * GenericCrudService bean is available in the Spring context.
 *
 * Example usage for a specific entity (e.g., User with Long ID):
 *   /api/users          → GET (list), POST (create)
 *   /api/users/{id}     → GET (by id), PUT (update), DELETE
 *
 * @param T the entity type (must extend Entity<ID>)
 * @param ID the identifier type
 */
@RestController
class GenericCrudController<T : Entity<ID>, ID>(
    @Suppress("SpringJavaInjectionPointsAutowiringInspection")
    private val service: GenericCrudService<T, ID>
) {

    @GetMapping
    fun findAll(): List<T> {
        return service.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: ID): ResponseEntity<T> {
        val entity = service.findById(id)
        return if (entity != null) {
            ResponseEntity.ok(entity)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody entity: T): T {
        // Note: for creation, the ID should typically be null or ignored
        return service.save(entity)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: ID, @RequestBody entity: T): ResponseEntity<T> {
        // Basic implementation: assumes the entity carries the correct ID or ignores it
        // In a real scenario, validation that the path ID matches entity.id could be added
        val updated = service.save(entity)
        return ResponseEntity.ok(updated)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: ID) {
        service.deleteById(id)
    }
}