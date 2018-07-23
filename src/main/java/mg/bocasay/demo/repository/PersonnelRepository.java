package mg.bocasay.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.bocasay.demo.entity.Personnel;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

}
