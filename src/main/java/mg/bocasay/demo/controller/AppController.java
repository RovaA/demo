package mg.bocasay.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mg.bocasay.demo.entity.Todo;
import mg.bocasay.demo.service.TodoService;

@Controller
public class AppController {

	@Autowired
	TodoService todoService;

	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index", "entities", todoService.findAll());
	}

	@GetMapping("/create")
	public ModelAndView createForm() {
		return new ModelAndView("form", "todo", new Todo());
	}

	@PostMapping("/create")
	public String createSubmit(@ModelAttribute Todo todo) {
		todoService.save(todo);
		return "redirect:";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam Long id) {
		todoService.delete(todoService.find(id));
		return "redirect:";
	}
}
