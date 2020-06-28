package com.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        String topicName = "MyFirstTopic1";
        String key = "Key1";
        String value = "Hola kafka";

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092,localhost:9093");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(properties);

        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, key, value);
        producer.send(record);
        producer.close();
        System.out.println("Simple Producer Completed.");
    }
}
