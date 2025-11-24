package org.hibernate.bugs;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import org.hibernate.annotations.BatchSize;

import java.util.Set;

@Entity
public class KeywordAssetRequest extends Request {

	@ElementCollection
	@BatchSize(size = 20)
	private Set<String> tokens;

}
