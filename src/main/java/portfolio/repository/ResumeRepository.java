package portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.entity.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
