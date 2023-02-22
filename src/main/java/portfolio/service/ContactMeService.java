package portfolio.service;

import portfolio.entity.ContactMe;
import portfolio.exception.PortfolioNotFound;

import java.util.List;

public interface ContactMeService {

    List<ContactMe> getAllContactContent(ContactMe contactMe) throws PortfolioNotFound;
    ContactMe addContactContent (ContactMe contactMe);
    ContactMe updateContactContent (ContactMe contactMe, Long id) throws PortfolioNotFound;
    void deleteContactContent (Long id) throws PortfolioNotFound;
}
