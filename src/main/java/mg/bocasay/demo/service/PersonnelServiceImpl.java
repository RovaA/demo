package mg.bocasay.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.bocasay.demo.domain.Personnel;
import mg.bocasay.demo.repository.PersonnelRepository;

@Service
public class PersonnelServiceImpl extends AbsServiceImpl<Personnel, Long, PersonnelRepository> implements PersonnelService {

	@Autowired
	public PersonnelServiceImpl(PersonnelRepository repository) {
		super(repository);
	}

}
