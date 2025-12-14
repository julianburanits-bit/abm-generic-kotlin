package com.julianburanits.abmgenerickotlin.domain.model

/**
 * Marker interface to identify domain entities.
 * Generics are used so each entity can have its own ID type.
 */
interface Entity<ID> {
    val id: ID?
}