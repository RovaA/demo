package mg.bocasay.demo.service;

import java.util.List;

import mg.bocasay.demo.domain.IsEntity;

public interface IsService<E extends IsEntity<I>, I> {

	E find(I id);

	List<E> findAll();

	E save(E entity);

	void delete(E entity);
}
