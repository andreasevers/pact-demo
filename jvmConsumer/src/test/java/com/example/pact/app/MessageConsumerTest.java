package com.example.pact.app;

import au.com.dius.pact.consumer.MessagePactBuilder;
import au.com.dius.pact.consumer.MessagePactProviderRule;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.model.v3.messaging.MessagePact;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andreas Evers
 */
public class MessageConsumerTest {

	@Rule
	public MessagePactProviderRule mockProvider = new MessagePactProviderRule(this);

	@Pact(provider = "provider1", consumer = "jvmConsumer-message")
	public MessagePact createPact(MessagePactBuilder builder) {
		//Alert alert = new Alert("Alert!");
		PactDslJsonBody body = new PactDslJsonBody().stringValue("message", "Alert!");

		Map<String, String> metadata = new HashMap<String, String>();
		metadata.put("contentType", "application/json");

		MessagePact messagePact = builder.expectsToReceive("Alert!").withMetadata(metadata).withContent(body).toPact();
		return messagePact;
	}

	@Test
	@PactVerification
	public void test() throws Exception {
		Assert.assertNotNull("");
	}

	public void setMessage(byte[] messageContents) {
		currentMessage = messageContents;
	}

	private byte[] currentMessage;
}
