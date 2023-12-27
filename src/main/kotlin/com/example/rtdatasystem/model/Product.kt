package com.example.rtdatasystem.model

import org.springframework.data.annotation.Id
import org.springframework.data.cassandra.core.mapping.Table
import java.util.UUID

@Table("products")
data class Product(
    @Id val productId: UUID = UUID.randomUUID(),
    var name: String?,
    var price: Double?,
    var stockQuantity: Int?,
    var description: String?,
    var category: String?,
    var customerId: UUID?,
)
