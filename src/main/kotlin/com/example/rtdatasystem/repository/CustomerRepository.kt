package com.example.rtdatasystem.repository

import com.example.rtdatasystem.model.Customer

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.data.cassandra.repository.Query
import java.util.*


@Repository
interface CustomerRepository : CrudRepository<Customer, UUID>{

    @Query("SELECT * FROM customers WHERE customerId = ?0")
    override fun findById(customerId: UUID): Optional<Customer>

}
