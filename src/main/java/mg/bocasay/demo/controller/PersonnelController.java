package mg.bocasay.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.bocasay.demo.domain.Personnel;
import mg.bocasay.demo.service.PersonnelService;

@RestController
@RequestMapping("/api/personnel")
public class PersonnelController {

	protected PersonnelService service;

	@Autowired
	public PersonnelController(PersonnelService service) {
		this.service = service;
	}

	@PostMapping("/create")
	public Personnel create(@RequestBody Personnel personnel) {
		return service.save(personnel);
	}

	@GetMapping("/list")
	public List<Personnel> list() {
		return service.findAll();
	}

}
