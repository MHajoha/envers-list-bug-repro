package org.example;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.time.Instant;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnversListTest {

	private EntityManager entityManager;

	@BeforeEach
	void setup() {
		final EntityManagerFactory factory = Persistence.createEntityManagerFactory("org.example");
		entityManager = factory.createEntityManager();
	}

	@Test
	void Should_Work() {
		final MyEntity entity = new MyEntity();
		entity.setId(1);

		final MyEmbeddable element1 = new MyEmbeddable();
		element1.setMyInstant(Instant.parse("2021-07-05T12:00:00Z"));

		final MyEmbeddable element2 = new MyEmbeddable();
		element2.setMyInstant(Instant.parse("2021-07-05T20:00:00Z"));

		entity.setList(List.of(element1, element2));

		entityManager.getTransaction().begin();

		entityManager.persist(entity);

		assertThatCode(() -> entityManager.getTransaction().commit())
				.doesNotThrowAnyException();
	}
}
