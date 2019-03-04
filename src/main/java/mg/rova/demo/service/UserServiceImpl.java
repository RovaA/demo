package mg.rova.demo.service;

import mg.rova.demo.service.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mg.rova.demo.domain.User;
import mg.rova.demo.repository.UserRepository;

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
		User user = repository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
		return new UserDetailsImpl(user);
	}

	@Override
	public User save(User entity) {
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		return super.save(entity);
	}

}
