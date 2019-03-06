package mg.rova.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mg.rova.demo.domain.Todo;
import mg.rova.demo.service.TodoService;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

	protected TodoService service;

	@Autowired
	public TodoController(TodoService service) {
		this.service = service;
	}

	@PostMapping
	public Todo create(@RequestBody Todo todo) {
		return service.save(todo);
	}

	@PostMapping("/{id}")
	public Todo update(@RequestBody Todo todo) {
		return service.save(todo);
	}

	@GetMapping
	public List<Todo> list() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Todo find(@PathVariable Long id) {
		return service.find(id);
	}

	@GetMapping("/find/{term}")
	public List<Todo> findByText(@PathVariable String term) {
		return service.findByText(term);
	}

	@DeleteMapping
	public void delete(@RequestParam Long id) {
		service.delete(service.find(id));
	}
}
