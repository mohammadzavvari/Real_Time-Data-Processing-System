package com.example.rtdatasystem.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import com.example.rtdatasystem.model.Product
import com.example.rtdatasystem.service.ProductService
import java.util.UUID

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun getAllProducts(): ResponseEntity<Iterable<Product>> =
        ResponseEntity.ok(productService.getAllProducts())

    @GetMapping("/{productId}")
    fun getProduct(@PathVariable productId: UUID): ResponseEntity<Product> =
        productService.getProductById(productId)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createProduct(@RequestBody product: Product): ResponseEntity<Product> =
        ResponseEntity.ok(productService.createProduct(product))


    @PutMapping("/{productId}")
    fun updateProduct(@PathVariable productId: UUID, @RequestBody updatedProduct: Product): ResponseEntity<Product>{

        val existingProduct = productService.getProductById(productId)

        if (existingProduct == null) return ResponseEntity.notFound().build()
        else{
            val updated = productService.updateProduct(existingProduct, updatedProduct)
            return ResponseEntity.ok(updated)
        }
    }

    @DeleteMapping("/{productId}")
    fun deleteProduct(@PathVariable productId: UUID){
        productService.deleteProduct(productId)
    }

}
