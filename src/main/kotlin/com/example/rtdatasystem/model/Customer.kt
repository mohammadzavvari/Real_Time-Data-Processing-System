package com.example.rtdatasystem.model

import org.springframework.data.annotation.Id
import org.springframework.data.cassandra.core.mapping.Table
import java.util.UUID

@Table("customers")
data class Customer(
    @Id val customerId: UUID = UUID.randomUUID(),
    var firstName: String,
    var lastName: String,
    var email: String,
    var address: String,
    var phone: String,
)
