package mg.bocasay.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.bocasay.demo.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
