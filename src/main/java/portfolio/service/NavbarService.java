package portfolio.service;

import portfolio.entity.Navbar;
import portfolio.exception.PortfolioNotFound;

import java.util.List;

public interface NavbarService {

    List<Navbar> getAllNavbarContent (Navbar navbar) throws PortfolioNotFound;
    Navbar addNavbarContent (Navbar navbar);
    Navbar updateNavbarContent (Navbar navbar, Long id) throws PortfolioNotFound;
    void deleteNavbarContent (Long id) throws PortfolioNotFound;
}
