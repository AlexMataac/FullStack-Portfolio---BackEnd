package portfolio.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.exception.PortfolioNotFound;
import portfolio.entity.Home;
import portfolio.repository.HomeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository repo;
    @Override
    public List<Home> getAllHomeContent(Home home) throws PortfolioNotFound {
        return repo.findAll();
    }

    @Override
    public Home addHomeContent(Home home) {
        return repo.save(home);
    }

    @Override
    public Home updateHomeContent(Home home, Long id) throws PortfolioNotFound {
        return repo.findById(id).map(home1 -> {
            home1.setName(home.getName());
            home1.setTypeWriter(home.getTypeWriter());
            home1.setDescription(home.getDescription());
            home1.setImage(home.getImage());
            return repo.save(home1);
        }).orElseThrow(() -> new PortfolioNotFound("NOT FOUND"));
    }

    @Override
    public void deleteHomeContent(Long id) throws PortfolioNotFound {
        Optional<Home> homeOptional = repo.findById(id);
        if (homeOptional.isEmpty()) {
            repo.findById(id).stream().filter(home -> home.getId() == id);
        } else repo.delete(homeOptional.get());
    }
}
