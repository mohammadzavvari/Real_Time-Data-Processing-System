package com.example.rtdatasystem.service
import org.springframework.stereotype.Service

import com.example.rtdatasystem.model.Customer
import com.example.rtdatasystem.repository.CustomerRepository
import com.example.rtdatasystem.service.serviceB.KafkaCustomerProducer
import java.util.UUID


@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val kafkaCustomerProducer: KafkaCustomerProducer
) {

    fun getAllCustomers(): Iterable<Customer> = customerRepository.findAll()

    fun getCustomerById(customerId: UUID): Customer? = customerRepository.findById(customerId).orElse(null)
    fun createCustomer(customer: Customer): Customer {
        val createdCustomer = customerRepository.save(customer)
        kafkaCustomerProducer.sendCustomer(createdCustomer)
        return createdCustomer
    }

    fun updateCustomer(existingCustomer: Customer, updatedCustomer: Customer): Customer {
        existingCustomer.firstName = updatedCustomer.firstName
        existingCustomer.lastName = updatedCustomer.lastName
        existingCustomer.email = updatedCustomer.email
        existingCustomer.address = updatedCustomer.address
        existingCustomer.phone = updatedCustomer.phone

        val newCustomer =  customerRepository.save(existingCustomer)
        kafkaCustomerProducer.sendCustomer(newCustomer)
        return newCustomer
    }

}
