package portfolio.service;

import portfolio.exception.PortfolioNotFound;
import portfolio.entity.AboutMe;

import java.util.List;

public interface AboutMeService {

    List<AboutMe> getAllAboutMeContent(AboutMe aboutMe) throws PortfolioNotFound;
    AboutMe addAboutMeContent (AboutMe aboutMe);
    AboutMe updateAboutMeContent (AboutMe aboutMe, Long id) throws PortfolioNotFound;
    void deleteAboutMeContent (Long id) throws PortfolioNotFound;
}
