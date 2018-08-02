package mg.bocasay.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.bocasay.demo.entity.IsEntity;

public abstract class AbsServiceImpl<E extends IsEntity<I>, I> implements IsService<E, I> {

	@Override
	public E find(I id) {
		return getRepository().findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public List<E> findAll() {
		return getRepository().findAll();
	}

	@Override
	public E save(E entity) {
		return getRepository().save(entity);
	}

	@Override
	public void delete(E entity) {
		getRepository().delete(entity);
	}

	protected abstract JpaRepository<E, I> getRepository();
}
