package portfolio.service;

import portfolio.entity.SocialLinks;
import portfolio.exception.PortfolioNotFound;

import java.util.List;

public interface SocialLinksService {

    List<SocialLinks> getAllSocialLinksContent (SocialLinks socialLinks) throws PortfolioNotFound;
    SocialLinks addSocialLinksContent (SocialLinks socialLinks);
    SocialLinks updateSocialLinksContent (SocialLinks socialLinks, Long id) throws PortfolioNotFound;
    void deleteSocialLinksContent (Long id) throws PortfolioNotFound;
}
