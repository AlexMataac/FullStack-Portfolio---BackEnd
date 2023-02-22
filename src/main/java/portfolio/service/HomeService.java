package portfolio.service;


import portfolio.exception.PortfolioNotFound;
import portfolio.entity.Home;

import java.util.List;

public interface HomeService {

    List<Home> getAllHomeContent(Home home) throws PortfolioNotFound;
    Home addHomeContent (Home home);
    Home updateHomeContent(Home home, Long id) throws PortfolioNotFound;
    void deleteHomeContent(Long id) throws PortfolioNotFound;
}
