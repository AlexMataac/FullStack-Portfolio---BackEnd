package portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.exception.PortfolioNotFound;
import portfolio.entity.AboutMe;
import portfolio.repository.AboutMeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AboutMeServiceImpl implements AboutMeService {

    @Autowired
    private AboutMeRepository repo;

    @Override
    public List<AboutMe> getAllAboutMeContent(AboutMe aboutMe) throws PortfolioNotFound {
        return repo.findAll();
    }

    @Override
    public AboutMe addAboutMeContent(AboutMe aboutMe) {
        return repo.save(aboutMe);
    }

    @Override
    public AboutMe updateAboutMeContent(AboutMe aboutMe, Long id) throws PortfolioNotFound {
        return repo.findById(id).map(aboutMe1 -> {
            aboutMe1.setName(aboutMe.getName());
            aboutMe1.setBirthday(aboutMe.getBirthday());
            aboutMe1.setAge(aboutMe.getAge());
            aboutMe1.setEducation(aboutMe.getEducation());
            aboutMe1.setStudy(aboutMe.getStudy());
            aboutMe1.setHobbies(aboutMe.getHobbies());
            aboutMe1.setLocation(aboutMe.getLocation());
            aboutMe1.setImage(aboutMe.getImage());
            return repo.save(aboutMe1);
        }).orElseThrow( () -> new PortfolioNotFound("NOT FOUND"));
    }

    @Override
    public void deleteAboutMeContent(Long id) throws PortfolioNotFound {
        Optional<AboutMe> optional = repo.findById(id);
        if (optional.isEmpty()) {
            repo.findById(id).stream().filter(aboutMe -> aboutMe.getId() == id);
        } else repo.delete(optional.get());
    }
}
