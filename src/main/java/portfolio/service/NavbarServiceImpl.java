package portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.entity.Navbar;
import portfolio.exception.PortfolioNotFound;
import portfolio.repository.NavbarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NavbarServiceImpl implements NavbarService {

    @Autowired
    private NavbarRepository repo;

    @Override
    public List<Navbar> getAllNavbarContent(Navbar navbar) throws PortfolioNotFound {
        return repo.findAll();
    }

    @Override
    public Navbar addNavbarContent(Navbar navbar) {
        return repo.save(navbar);
    }

    @Override
    public Navbar updateNavbarContent(Navbar navbar, Long id) throws PortfolioNotFound {
        return repo.findById(id).map(navbar1 -> {
            navbar1.setLogo(navbar.getLogo());
            navbar1.setHome(navbar.getHome());
            navbar1.setAboutMe(navbar.getAboutMe());
            navbar1.setResume(navbar.getResume());
            navbar1.setExperience(navbar.getExperience());
            navbar1.setProject(navbar.getProject());
            navbar1.setContactMe(navbar.getContactMe());
            return repo.save(navbar1);
        }).orElseThrow( () -> new PortfolioNotFound("NOT FOUND"));
    }

    @Override
    public void deleteNavbarContent(Long id) throws PortfolioNotFound {
        Optional<Navbar> optional = repo.findById(id);
        if (optional.isEmpty()) {
            repo.findById(id).stream().filter(navbar -> navbar.getId() == id);
        } else repo.delete(optional.get());
    }
}
