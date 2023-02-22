package portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.entity.ContactMe;
import portfolio.exception.PortfolioNotFound;
import portfolio.repository.ContactMeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContactMeServiceImpl implements ContactMeService {

    @Autowired
    private ContactMeRepository repo;

    @Override
    public List<ContactMe> getAllContactContent(ContactMe contactMe) throws PortfolioNotFound {
        return repo.findAll();
    }

    @Override
    public ContactMe addContactContent(ContactMe contactMe) {
        return repo.save(contactMe);
    }

    @Override
    public ContactMe updateContactContent(ContactMe contactMe, Long id) throws PortfolioNotFound {
        return repo.findById(id).map(contactMe1 -> {
            contactMe1.setName(contactMe.getName());
            contactMe1.setEmail(contactMe.getEmail());
            contactMe1.setMessage(contactMe.getMessage());
            return repo.save(contactMe1);
        }).orElseThrow( () -> new PortfolioNotFound("NOT FOUND"));
    }

    @Override
    public void deleteContactContent(Long id) throws PortfolioNotFound {
        Optional<ContactMe> optional = repo.findById(id);
        if (optional.isEmpty()) {
            repo.findById(id).stream().filter(contactMe -> contactMe.getId() == id);
        } else repo.delete(optional.get());
    }
}
