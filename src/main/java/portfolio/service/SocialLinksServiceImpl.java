package portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.entity.SocialLinks;
import portfolio.exception.PortfolioNotFound;
import portfolio.repository.SocialLinksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SocialLinksServiceImpl implements SocialLinksService {

    @Autowired
    private SocialLinksRepository repo;

    @Override
    public List<SocialLinks> getAllSocialLinksContent(SocialLinks socialLinks) throws PortfolioNotFound {
        return repo.findAll();
    }

    @Override
    public SocialLinks addSocialLinksContent(SocialLinks socialLinks) {
        return repo.save(socialLinks);
    }

    @Override
    public SocialLinks updateSocialLinksContent(SocialLinks socialLinks, Long id) throws PortfolioNotFound {
        return repo.findById(id).map(socialLinks1 -> {
            socialLinks1.setFaceBook(socialLinks.getFaceBook());
            socialLinks1.setLinkedIn(socialLinks.getLinkedIn());
            socialLinks1.setGitHub(socialLinks.getGitHub());
            socialLinks1.setMail(socialLinks.getMail());
            socialLinks1.setResume(socialLinks.getResume());
            return repo.save(socialLinks1);
        }).orElseThrow( () -> new PortfolioNotFound("NOT FOUND"));
    }

    @Override
    public void deleteSocialLinksContent(Long id) throws PortfolioNotFound {
        Optional<SocialLinks> optional = repo.findById(id);
        if (optional.isEmpty()) {
            repo.findById(id).stream().filter(socialLinks -> socialLinks.getId() == id);
        } else repo.delete(optional.get());
    }
}
