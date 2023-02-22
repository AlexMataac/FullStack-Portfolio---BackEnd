package portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.entity.ContactMe;
@Repository
public interface ContactMeRepository extends JpaRepository<ContactMe, Long> {
}
