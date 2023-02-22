package portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.entity.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {
}
