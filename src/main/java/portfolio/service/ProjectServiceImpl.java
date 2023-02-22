package portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.entity.Project;
import portfolio.exception.PortfolioNotFound;
import portfolio.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repo;

    @Override
    public List<Project> getAllProjectContent(Project project) throws PortfolioNotFound {
        return repo.findAll();
    }

    @Override
    public Project addProjectContent(Project project) {
        return repo.save(project);
    }

    @Override
    public Project updateProjectContent(Project project, Long id) throws PortfolioNotFound {
        return repo.findById(id).map(project1 -> {
            project1.setImage(project.getImage());
            project1.setTitle(project.getTitle());
            project1.setDescription(project.getDescription());
            project1.setLink(project.getLink());
            return repo.save(project1);
        }).orElseThrow( () -> new PortfolioNotFound("NOT FOUND"));
    }

    @Override
    public void deleteProjectContent(Long id) throws PortfolioNotFound {
        Optional<Project> optional = repo.findById(id);
        if (optional.isEmpty()) {
            repo.findById(id).stream().filter(project -> project.getId() == id);
        } else repo.delete(optional.get());
    }
}
