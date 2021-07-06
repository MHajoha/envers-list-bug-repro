package org.example;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class MyEmbeddable {

	@Column(nullable = false)
	private Instant myInstant;
}
