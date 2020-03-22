package com.example.pact.app;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class AlertReceiver {

	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveAlert(Alert message) {
		System.out.println("Received <" + message + ">");
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
