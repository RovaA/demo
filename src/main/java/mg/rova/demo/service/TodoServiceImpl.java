package mg.rova.demo.service;

import mg.rova.demo.repository.elastic.TodoSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.rova.demo.domain.Todo;
import mg.rova.demo.repository.TodoRepository;

import java.util.List;

@Service
public class TodoServiceImpl extends AbsServiceImpl<Todo, Long, TodoRepository> implements TodoService {

	@Autowired
	private TodoSearchRepository searchRepository;

	@Autowired
	public TodoServiceImpl(TodoRepository repository) {
		super(repository);
	}

	@Override
	public List<Todo> findByText(String text) {
		return searchRepository.findByText(text);
	}
}
