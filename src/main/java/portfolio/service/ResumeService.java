package portfolio.service;

import portfolio.exception.PortfolioNotFound;
import portfolio.entity.Resume;

import java.util.List;

public interface ResumeService {

    List<Resume> getAllResumeContent(Resume resume) throws PortfolioNotFound;
    Resume addResumeContent (Resume resume);
    Resume updateResumeContent (Resume resume, Long id) throws PortfolioNotFound;
    void deleteResumeContent (Long id) throws PortfolioNotFound;
}
