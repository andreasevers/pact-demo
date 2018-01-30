package com.example.pact.app;

import au.com.dius.pact.provider.PactVerifyProvider;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactBrokerAuth;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringMessagePactRunner;
import au.com.dius.pact.provider.spring.target.SpringAwareAmqpTarget;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Andreas Evers
 */
@RunWith(SpringMessagePactRunner.class)
@PactBroker(host = "localhost", port = "80", protocol = "http", authentication = @PactBrokerAuth(username = "shanelee007", password = "password123"))
@Provider("provider1")
@SpringBootTest(classes = PactDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventsContractTest {

	@TestTarget
	public final SpringAwareAmqpTarget target = new SpringAwareAmqpTarget();

	@PactVerifyProvider("an alert message")
	String verifyAlert() {
		return "";
	}

}
