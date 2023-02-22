package portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.entity.SocialLinks;
@Repository
public interface SocialLinksRepository extends JpaRepository<SocialLinks, Long> {
}
