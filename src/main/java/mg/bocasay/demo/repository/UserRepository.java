package mg.bocasay.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.bocasay.demo.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
