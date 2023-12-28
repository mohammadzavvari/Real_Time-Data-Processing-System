package com.example.rtdatasystem.repository

import com.example.rtdatasystem.model.Product
import com.example.rtdatasystem.model.ProductAggregationDTO

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.data.cassandra.repository.Query
import java.util.*


@Repository
interface ProductRepository : CrudRepository<Product, UUID> {

    @Query("SELECT * FROM products WHERE productId = ?0")
    override fun findById(productId: UUID): Optional<Product>

    @Query(
        value = "SELECT productId, " +
                "max(stockQuantity) as maxOfInventory" +
                " FROM spring_cassandra.products group by productId"
    )
    fun getProductAggregation(): List<ProductAggregationDTO>

}
