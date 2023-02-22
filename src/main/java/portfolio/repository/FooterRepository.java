package portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.entity.Footer;

@Repository
public interface FooterRepository extends JpaRepository<Footer, Long> {
}
