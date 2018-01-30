package com.example.pact.app;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactSpecVersion;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class RestConsumerTest {

    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("provider1", "localhost", 8080, PactSpecVersion.V3, this);

    @Pact(provider = "provider1", consumer = "jvmConsumer-rest")
    public RequestResponsePact createFragment(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");


        PactDslJsonBody bodyResponse = new PactDslJsonBody()
                .stringValue("name", "shane")
                .stringValue("salutation", "Mr.");

        return builder.uponReceiving("a request for Greetings")
                .path("/greetings/shane")
                .method(RequestMethod.GET.name())
                .willRespondWith()
                .headers(headers)
                .status(200).body(bodyResponse).toPact();
    }

    @Test
    @PactVerification
    public void runTest() throws IOException {
        get("/greetings/shane").then().body("name", equalTo("shane"));
    }

}
