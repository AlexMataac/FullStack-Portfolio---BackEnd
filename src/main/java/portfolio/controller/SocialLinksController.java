package portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.entity.SocialLinks;
import portfolio.exception.PortfolioNotFound;
import portfolio.service.FooterService;
import portfolio.service.SocialLinksService;

import java.util.List;

@RestController
@RequestMapping("/social_links")
@CrossOrigin("http://localhost:3000/")
public class SocialLinksController {

    @Autowired
    private SocialLinksService service;

    @GetMapping
    public ResponseEntity<List<SocialLinks>> getAllSocialLinksContent(SocialLinks socialLinks) throws PortfolioNotFound {
        List<SocialLinks> socialLinksList = service.getAllSocialLinksContent(socialLinks);
        return new ResponseEntity<List<SocialLinks>>(socialLinksList, HttpStatus.OK);
    }
    @PostMapping
    public SocialLinks addSocialLinksContent(@RequestBody SocialLinks socialLinks) {
        return service.addSocialLinksContent(socialLinks);
    }
    @PutMapping("/{id}")
    public SocialLinks updateSocialLinksContent(@RequestBody SocialLinks socialLinks, @PathVariable Long id) throws PortfolioNotFound {
        return service.updateSocialLinksContent(socialLinks, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSocialLinksContent (@PathVariable Long id) throws PortfolioNotFound {
        service.deleteSocialLinksContent(id);
        return new ResponseEntity<>("The content has been deleted", HttpStatus.OK);
    }
}
