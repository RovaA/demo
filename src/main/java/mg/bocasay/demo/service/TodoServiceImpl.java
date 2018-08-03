package mg.bocasay.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import mg.bocasay.demo.domain.Todo;
import mg.bocasay.demo.repository.TodoRepository;

@Scope(value = "singleton")
@Service
public class TodoServiceImpl extends AbsServiceImpl<Todo, Long> implements TodoService {

	@Autowired
	protected TodoRepository repository;

	@Override
	protected JpaRepository<Todo, Long> getRepository() {
		return repository;
	}

}
