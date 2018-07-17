package mg.bocasay.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.bocasay.demo.entity.Todo;
import mg.bocasay.demo.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;

	public Todo find(Long id) {
		return repository.findById(id).orElse(new Todo());
	}

	public List<Todo> findAll() {
		return repository.findAll();
	}

	public void save(Todo todo) {
		repository.save(todo);
	}

	public void delete(Todo todo) {
		repository.delete(todo);
	}
}
