package com.example.rtdatasystem.service

import org.springframework.stereotype.Service

import com.example.rtdatasystem.model.Product
import com.example.rtdatasystem.repository.ProductRepository
import java.util.UUID

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getAllProducts(): Iterable<Product> = productRepository.findAll()

    fun getProductById(productId: UUID): Product? = productRepository.findById(productId).orElse(null)

    fun createProduct(product: Product): Product = productRepository.save(product)

}