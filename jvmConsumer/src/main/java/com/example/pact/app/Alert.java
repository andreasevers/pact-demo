package com.example.pact.app;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Alert implements Serializable {

	@Builder.Default
	private String message = "Alert!";
}
