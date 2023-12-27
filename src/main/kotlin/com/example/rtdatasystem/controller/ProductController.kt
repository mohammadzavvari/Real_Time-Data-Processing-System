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

    @GetMapping("/{productID}")
    fun getProduct(@PathVariable productID: UUID): ResponseEntity<Product> =
        productService.getProductById(productID)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createProduct(@RequestBody product: Product): ResponseEntity<Product> =
        ResponseEntity.ok(productService.createProduct(product))


//    @PutMapping
//    fun updateProduct(@RequestBody product: Product): ResponseEntity<Product> =
//        ResponseEntity
}
