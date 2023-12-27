package com.example.rtdatasystem.service.serviceB

import com.example.rtdatasystem.model.Customer
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.KafkaListener

import org.springframework.stereotype.Service

@EnableKafka
@Service
class KafkaCustomerConsumer{

    @KafkaListener(topics = ["customer-topic"], groupId = "my-group-id-boot-spring")
    fun receive(customer: Customer) {
        println("Received message: ${customer.toString()}")
    }
}