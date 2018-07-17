package mg.bocasay.demo.service;

import java.util.List;

import mg.bocasay.demo.entity.Todo;

public interface TodoService {

	Todo find(Long id);

	List<Todo> findAll();

	void save(Todo todo);

	void delete(Todo todo);
}
