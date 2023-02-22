package portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.entity.Navbar;
@Repository
public interface NavbarRepository extends JpaRepository<Navbar, Long> {
}
