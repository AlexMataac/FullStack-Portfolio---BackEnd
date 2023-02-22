package portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.exception.PortfolioNotFound;
import portfolio.entity.Experience;
import portfolio.repository.ExperienceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository repo;
    @Override
    public List<Experience> getExperienceContent(Experience experience) throws PortfolioNotFound {
        return repo.findAll();
    }

    @Override
    public Experience addExperienceContent(Experience experience) {
        return repo.save(experience);
    }

    @Override
    public Experience updateExperienceContent(Experience experience, Long id) throws PortfolioNotFound {
        return repo.findById(id).map(experience1 -> {
            experience1.setItems(experience.getItems());
            experience1.setImages(experience.getImages());
            return repo.save(experience1);
        }).orElseThrow( () -> new PortfolioNotFound("NOT FOUND"));
    }

    @Override
    public void deleteExperienceContent(Long id) throws PortfolioNotFound {
        Optional<Experience> optional = repo.findById(id);
        if (optional.isEmpty()) {
            repo.findById(id).stream().filter(experience -> experience.getId() == id);
        } else repo.delete(optional.get());
    }
}
