package org.example;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;

import org.hibernate.envers.Audited;

import lombok.Data;

@Entity
@Audited
@Data
public class MyEntity {

	@Id
	private long id;

	// using @OrderColumn or a set here works
	@ElementCollection
	@OrderBy("myInstant ASC")
	private List<MyEmbeddable> list;
}
