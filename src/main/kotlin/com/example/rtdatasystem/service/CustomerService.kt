package com.example.rtdatasystem.service
import org.springframework.stereotype.Service

import com.example.rtdatasystem.model.Customer
import com.example.rtdatasystem.model.Product
import com.example.rtdatasystem.repository.CustomerRepository
import java.util.UUID


@Service
class CustomerService(private val customerRepository: CustomerRepository) {

    fun getAllCustomers(): Iterable<Customer> = customerRepository.findAll()

    fun getCustomerById(customerId: UUID): Customer? = customerRepository.findById(customerId).orElse(null)

    fun createCustomer(customer: Customer): Customer = customerRepository.save(customer)

    fun updateCustomer(existingCustomer: Customer, updatedCustomer: Customer): Customer {
        existingCustomer.firstName = updatedCustomer.firstName
        existingCustomer.lastName = updatedCustomer.lastName
        existingCustomer.email = updatedCustomer.email
        existingCustomer.address = updatedCustomer.address
        existingCustomer.phone = updatedCustomer.phone

        return customerRepository.save(existingCustomer)
    }

}
