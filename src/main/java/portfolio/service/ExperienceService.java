package portfolio.service;

import portfolio.exception.PortfolioNotFound;
import portfolio.entity.Experience;

import java.util.List;

public interface ExperienceService {

    List<Experience> getExperienceContent(Experience experience) throws PortfolioNotFound;
    Experience addExperienceContent (Experience experience);
    Experience updateExperienceContent (Experience experience, Long id) throws PortfolioNotFound;
    void deleteExperienceContent (Long id) throws PortfolioNotFound;
}
