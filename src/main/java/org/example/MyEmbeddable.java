package org.example;

import java.time.Instant;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class MyEmbeddable {

	private Instant myInstant;
}
