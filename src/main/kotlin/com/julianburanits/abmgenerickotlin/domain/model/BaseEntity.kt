package com.julianburanits.abmgenerickotlin.domain.model

import java.io.Serializable

/**
 * Optional base class for entities that use Long as ID.
 * Useful for future examples, but not mandatory.
 */
abstract class BaseEntity(
    override val id: Long? = null
) : Entity<Long>, Serializable