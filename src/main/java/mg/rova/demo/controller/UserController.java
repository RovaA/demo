package mg.rova.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mg.rova.demo.domain.Role;
import mg.rova.demo.domain.User;
import mg.rova.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	protected UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/signup")
	public ModelAndView signup() {
		final ModelAndView modelAndView = new ModelAndView("signup");
		modelAndView.addObject("user", new User());
		modelAndView.addObject("roles", Role.values());
		return modelAndView;
	}

	@PostMapping("/create")
	public String createUser(@ModelAttribute("user") User user) {
		userService.create(user);
		return "redirect:/";
	}

}
