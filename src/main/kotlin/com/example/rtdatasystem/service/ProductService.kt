package com.example.rtdatasystem.service

import org.springframework.stereotype.Service

import com.example.rtdatasystem.model.Product
import com.example.rtdatasystem.repository.ProductRepository
import com.example.rtdatasystem.service.serviceB.KafkaProductProducer
import java.util.UUID

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val kafkaProductProducer: KafkaProductProducer) {

    fun getAllProducts(): Iterable<Product> = productRepository.findAll()

    fun getProductById(productId: UUID): Product? = productRepository.findById(productId).orElse(null)

    fun createProduct(product: Product): Product{
        val createdProduct = productRepository.save(product)
        kafkaProductProducer.sendProduct(createdProduct)
        return createdProduct
    }

    fun updateProduct(existingProduct: Product, updatedProduct: Product): Product {
        existingProduct.name = updatedProduct.name
        existingProduct.price = updatedProduct.price
        existingProduct.stockQuantity = updatedProduct.stockQuantity
        existingProduct.description = updatedProduct.description
        existingProduct.category = updatedProduct.category
        existingProduct.customerId = updatedProduct.customerId

        val newProduct =  productRepository.save(existingProduct)
        kafkaProductProducer.sendProduct(newProduct)
        return newProduct
    }

    fun deleteProduct(productId: UUID){
        productRepository.deleteById(productId)
    }
}