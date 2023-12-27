package com.example.rtdatasystem.repository

import com.example.rtdatasystem.model.Product

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.data.cassandra.repository.Query
import java.util.*


@Repository
interface ProductRepository : CrudRepository<Product, UUID> {

    @Query("SELECT * FROM products WHERE productId = ?0")
    override fun findById(productId: UUID): Optional<Product>

}