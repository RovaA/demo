package mg.bocasay.demo.service;

import java.util.List;

public interface IsService<E, I> {

	E find(I id);

	List<E> findAll();

	E save(E entity);

	void delete(E entity);
}
