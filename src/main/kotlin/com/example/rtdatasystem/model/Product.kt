package com.example.rtdatasystem.model

import com.fasterxml.jackson.annotation.JsonAutoDetect
import org.springframework.data.annotation.Id
import org.springframework.data.cassandra.core.mapping.Table
import java.util.UUID

@Table("products")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class Product(
    @Id val productId: UUID = UUID.randomUUID(),
    var name: String?,
    var price: Double?,
    var stockQuantity: Int?,
    var description: String?,
    var category: String?,
    var customerId: UUID?,
)
