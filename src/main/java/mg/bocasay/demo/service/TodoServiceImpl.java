package mg.bocasay.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.bocasay.demo.entity.Todo;
import mg.bocasay.demo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository repository;

	@Override
	public Todo find(Long id) {
		return repository.findById(id).orElse(new Todo());
	}

	@Override
	public List<Todo> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Todo todo) {
		repository.save(todo);
	}

	@Override
	public void delete(Todo todo) {
		repository.delete(todo);
	}
}
