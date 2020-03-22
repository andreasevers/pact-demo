package com.example.pact.app;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactBrokerAuth;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Andreas Evers
 */
@RunWith(SpringRestPactRunner.class)
@PactBroker(host = "localhost", port = "80", protocol = "http", authentication = @PactBrokerAuth(username = "shanelee007", password = "password123"))
@Provider("provider1")
@SpringBootTest(classes = PactDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestContractTest {

	@TestTarget
	public final MockMvcTarget target = new MockMvcTarget();

	@Before
	public void setUp() {
		GreetingsController greetingsController = new GreetingsController();
		target.setControllers(greetingsController);
	}


}
