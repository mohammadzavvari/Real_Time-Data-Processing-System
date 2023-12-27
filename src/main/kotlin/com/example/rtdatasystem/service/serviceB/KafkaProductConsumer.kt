package com.example.rtdatasystem.service.serviceB

import com.example.rtdatasystem.model.Product
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.KafkaListener

import org.springframework.stereotype.Service

@EnableKafka
@Service
class KafkaProductConsumer{

    @KafkaListener(topics = ["product-topic"], groupId = "my-group-id-boot-spring")
    fun receive(product: Product) {
        println("Received message: ${product.toString()}")
    }
}
