package portfolio.service;

import portfolio.entity.Project;
import portfolio.exception.PortfolioNotFound;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjectContent(Project project) throws PortfolioNotFound;
    Project addProjectContent (Project project);
    Project updateProjectContent (Project project, Long id) throws PortfolioNotFound;
    void deleteProjectContent (Long id) throws PortfolioNotFound;
}
