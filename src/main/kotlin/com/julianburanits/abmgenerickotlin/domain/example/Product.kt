package com.julianburanits.abmgenerickotlin.domain.example

import com.julianburanits.abmgenerickotlin.domain.model.Entity

/**
 * Example domain entity: Product.
 * Uses Long as ID for simplicity.
 */
data class Product(
    val name: String,
    val price: Double,
    val description: String? = null,
    override val id: Long? = null
) : Entity<Long>