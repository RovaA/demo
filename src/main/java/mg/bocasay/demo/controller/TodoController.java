package mg.bocasay.demo.controller;

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

import mg.bocasay.demo.entity.Todo;
import mg.bocasay.demo.service.TodoService;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

	@Autowired
	protected TodoService service;

	@PostMapping("/create")
	public Todo create(@RequestBody Todo todo) {
		return service.save(todo);
	}

	@GetMapping("/list")
	public List<Todo> list() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Todo find(@PathVariable Long id) {
		return service.find(id);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam Long id) {
		service.delete(service.find(id));
	}
}
