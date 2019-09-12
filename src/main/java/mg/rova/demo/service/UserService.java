package mg.rova.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import mg.rova.demo.domain.User;

public interface UserService extends IsService<User, Long>, UserDetailsService {

    User create(User user);
}
