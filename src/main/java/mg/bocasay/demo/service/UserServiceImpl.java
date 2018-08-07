package mg.bocasay.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mg.bocasay.demo.domain.User;
import mg.bocasay.demo.repository.UserRepository;

@Service
public class UserServiceImpl extends AbsServiceImpl<User, Long, UserRepository> implements UserService {

	@Autowired
	protected PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository repository) {
		super(repository);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = repository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
		return user;
	}

	@Override
	public User save(User entity) {
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		return super.save(entity);
	}

}
