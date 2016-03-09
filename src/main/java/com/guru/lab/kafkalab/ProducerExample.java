package com.guru.lab.kafkalab;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class ProducerExample {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put("metadata.broker.list", "host name/IP:9092");
		props.put("port", "9092");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
//		props.put("request.required.acks", "1");

		ProducerConfig config = new ProducerConfig(props);

		Producer<String, String> producer = new Producer<String, String>(config);

		String topic = "guru_topic";

		String msg = "Message from Guru!!";
		KeyedMessage<String, String> data = new KeyedMessage<String, String>(
				topic, null, msg);
		producer.send(data);

		System.out.println("Messages published...");
		producer.close();
	}

}
