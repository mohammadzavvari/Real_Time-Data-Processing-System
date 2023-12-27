package com.example.rtdatasystem.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import com.example.rtdatasystem.model.Customer
import com.example.rtdatasystem.service.CustomerService
import java.util.UUID

@RestController
@RequestMapping("/customers")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping
    fun getAllCustomers(): ResponseEntity<Iterable<Customer>> =
        ResponseEntity.ok(customerService.getAllCustomers())

    @GetMapping("/{customerId}")
    fun getCustomer(@PathVariable customerId: UUID): ResponseEntity<Customer> =
        customerService.getCustomerById(customerId)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createCustomer(@RequestBody customer: Customer): ResponseEntity<Customer> =
        ResponseEntity.ok(customerService.createCustomer(customer))

    @PutMapping("/{customerId}")
    fun updateCustomer(@PathVariable customerId: UUID, @RequestBody updatedCustomer: Customer): ResponseEntity<Customer>{

        val existingCustomer = customerService.getCustomerById(customerId)

        if (existingCustomer == null) return ResponseEntity.notFound().build()
        else{
            val updated = customerService.updateCustomer(existingCustomer, updatedCustomer)
            return ResponseEntity.ok(updated)
        }
    }
}
