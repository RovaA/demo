package mg.rova.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.rova.demo.domain.Todo;
import mg.rova.demo.repository.TodoRepository;

@Service
public class TodoServiceImpl extends AbsServiceImpl<Todo, Long, TodoRepository> implements TodoService {

	@Autowired
	public TodoServiceImpl(TodoRepository repository) {
		super(repository);
	}

}
