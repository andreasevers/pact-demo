package com.example.pact.app;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class AlertSender implements CommandLineRunner {

	private final RabbitTemplate rabbitTemplate;
	private final AlertReceiver receiver;
	private final ConfigurableApplicationContext context;

	public AlertSender(AlertReceiver receiver, RabbitTemplate rabbitTemplate,
					   ConfigurableApplicationContext context) {
		this.receiver = receiver;
		this.rabbitTemplate = rabbitTemplate;
		this.context = context;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(AlertConfiguration.queueName, Alert.builder().message("Alert!").build());
		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		//context.close();
	}

}
