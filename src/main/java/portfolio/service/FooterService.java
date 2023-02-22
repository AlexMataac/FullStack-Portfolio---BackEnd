package portfolio.service;

import portfolio.entity.Footer;
import portfolio.exception.PortfolioNotFound;

import java.util.List;

public interface FooterService {

    List<Footer> getAllFooterContent (Footer footer) throws PortfolioNotFound;
    Footer addFooterContent (Footer footer);
    Footer updateFooterContent (Footer footer, Long id) throws PortfolioNotFound;
    void deleteFooterContent (Long id) throws PortfolioNotFound;
}
