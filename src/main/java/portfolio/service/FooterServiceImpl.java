package portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.entity.Footer;
import portfolio.exception.PortfolioNotFound;
import portfolio.repository.FooterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FooterServiceImpl implements FooterService {

    @Autowired
    private FooterRepository repo;

    @Override
    public List<Footer> getAllFooterContent(Footer footer) throws PortfolioNotFound {
        return repo.findAll();
    }

    @Override
    public Footer addFooterContent(Footer footer) {
        return repo.save(footer);
    }

    @Override
    public Footer updateFooterContent(Footer footer, Long id) throws PortfolioNotFound {
        return repo.findById(id).map(footer1 -> {
            footer1.setFaceBook(footer.getFaceBook());
            footer1.setLinkedIn(footer.getLinkedIn());
            footer1.setGitHub(footer.getGitHub());
            footer1.setMail(footer.getMail());
            footer1.setClosingTag(footer.getClosingTag());
            return repo.save(footer1);
        }).orElseThrow( () -> new PortfolioNotFound("NOT FOUND"));
    }

    @Override
    public void deleteFooterContent(Long id) throws PortfolioNotFound {
        Optional<Footer> optional = repo.findById(id);
        if (optional.isEmpty()) {
            repo.findById(id).stream().filter(footer -> footer.getId() == id);
        } else repo.delete(optional.get());
    }
}
