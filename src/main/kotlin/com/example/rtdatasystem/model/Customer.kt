package com.example.rtdatasystem.model

import org.springframework.data.annotation.Id
import org.springframework.data.cassandra.core.mapping.Table
import java.util.UUID

@Table("customers")
data class Customer(
    @Id val customerId: UUID = UUID.randomUUID(),
    val firstName: String,
    val lastName: String,
    val email: String,
    val address: String,
    val phone: String,
)
