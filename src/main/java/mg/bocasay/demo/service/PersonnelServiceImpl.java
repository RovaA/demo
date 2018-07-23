package mg.bocasay.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mg.bocasay.demo.entity.Personnel;
import mg.bocasay.demo.repository.PersonnelRepository;

@Scope(value = "singleton")
@Service
public class PersonnelServiceImpl implements PersonnelService {

	@Autowired
	protected PersonnelRepository repository;

	@Override
	public Personnel find(Long id) {
		return repository.findById(id).orElse(new Personnel());
	}

	@Override
	public List<Personnel> findAll() {
		return repository.findAll();
	}

	@Override
	public Personnel save(Personnel entity) {
		return repository.save(entity);
	}

	@Override
	public void delete(Personnel entity) {
		repository.delete(entity);
	}

}
