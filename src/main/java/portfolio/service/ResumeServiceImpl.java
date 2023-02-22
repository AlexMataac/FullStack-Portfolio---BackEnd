package portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.exception.PortfolioNotFound;
import portfolio.entity.Resume;
import portfolio.repository.ResumeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeRepository repo;
    @Override
    public List<Resume> getAllResumeContent(Resume resume) throws PortfolioNotFound {
        return repo.findAll();
    }

    @Override
    public Resume addResumeContent(Resume resume) {
        return repo.save(resume);
    }

    @Override
    public Resume updateResumeContent(Resume resume, Long id) throws PortfolioNotFound {
        return repo.findById(id).map(resume1 -> {
            resume1.setJob(resume.getJob());
            resume1.setPlace(resume.getPlace());
            resume1.setPeriod(resume.getPeriod());
            return repo.save(resume1);
        }).orElseThrow( () -> new PortfolioNotFound("NOT FOUND"));
    }

    @Override
    public void deleteResumeContent(Long id) throws PortfolioNotFound {
        Optional<Resume> optional = repo.findById(id);
        if (optional.isEmpty()) {
            repo.findById(id).stream().filter(resume -> resume.getId() == id);
        } else repo.delete(optional.get());
    }
}
