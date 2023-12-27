package com.example.rtdatasystem.service.serviceB

import com.example.rtdatasystem.model.Customer
import org.springframework.stereotype.Service
import org.springframework.kafka.core.KafkaTemplate

@Service
class KafkaCustomerProducer(private val kafkaTemplate: KafkaTemplate<String, Customer>) {
    val topic: String = "customer-topic"

    fun sendCustomer(customer: Customer){
        kafkaTemplate.send(topic, customer.customerId.toString(), customer)
    }
}

