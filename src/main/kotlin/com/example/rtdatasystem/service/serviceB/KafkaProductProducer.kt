package com.example.rtdatasystem.service.serviceB

import com.example.rtdatasystem.model.Product
import org.springframework.stereotype.Service
import org.springframework.kafka.core.KafkaTemplate


@Service
class KafkaProductProducer(private val kafkaTemplate: KafkaTemplate<String, Product>) {

    val topic: String = "product-topic"

    fun sendProduct(product: Product){
                kafkaTemplate.send(topic, product.productId.toString(), product)
            }

}