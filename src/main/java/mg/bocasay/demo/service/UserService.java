package mg.bocasay.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import mg.bocasay.demo.domain.User;

public interface UserService extends IsService<User, Long>, UserDetailsService {

}
