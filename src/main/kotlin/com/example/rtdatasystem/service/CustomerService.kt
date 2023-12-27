package com.example.rtdatasystem.service
import org.springframework.stereotype.Service

import com.example.rtdatasystem.model.Customer
import com.example.rtdatasystem.repository.CustomerRepository
import java.util.UUID


@Service
class CustomerService(private val customerRepository: CustomerRepository) {

    fun getAllCustomers(): Iterable<Customer> = customerRepository.findAll()

    fun getCustomerById(customerID: UUID): Customer? = customerRepository.findById(customerID).orElse(null)

    fun createCustomer(customer: Customer): Customer = customerRepository.save(customer)

}
