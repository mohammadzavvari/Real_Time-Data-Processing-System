package com.example.rtdatasystem.model

import org.springframework.data.annotation.Id
import org.springframework.data.cassandra.core.mapping.Table
import java.util.UUID

@Table("products")
data class Product(
    @Id val productId: UUID = UUID.randomUUID(),
    val name: String?,
    val price: Double?,
    val stockQuantity: Int?,
    val description: String?,
    val category: String?,
    val customerId: UUID?,
)
