package com.example.rtdatasystem.model

import java.util.UUID

data class ProductAggregationDTO(
    val productId: UUID,
//    val averagePrice: Long,
//    val productCount: Long,
    val maxOfInventory: Int
)
