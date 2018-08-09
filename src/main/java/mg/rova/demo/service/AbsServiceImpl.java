package mg.rova.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.rova.demo.domain.IsEntity;

public abstract class AbsServiceImpl<E extends IsEntity<I>, I, R extends JpaRepository<E, I>> implements IsService<E, I> {
	
	protected R repository;
	
	public AbsServiceImpl(R repository) {
		this.repository = repository;
	}

	@Override
	public E find(I id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public List<E> findAll() {
		return repository.findAll();
	}

	@Override
	public E save(E entity) {
		return repository.save(entity);
	}

	@Override
	public void delete(E entity) {
		repository.delete(entity);
	}

}
