package mg.rova.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.rova.demo.domain.Personnel;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

}
