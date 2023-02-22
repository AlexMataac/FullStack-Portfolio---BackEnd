package portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.entity.Footer;
import portfolio.exception.PortfolioNotFound;
import portfolio.service.AboutMeService;
import portfolio.service.FooterService;

import java.util.List;

@RestController
@RequestMapping("/footer")
@CrossOrigin("http://localhost:3000/")
public class FooterController {

    @Autowired
    private FooterService service;

    @GetMapping
    public ResponseEntity<List<Footer>> getAllFooterContent(Footer footer) throws PortfolioNotFound {
        List<Footer> footerList = service.getAllFooterContent(footer);
        return new ResponseEntity<List<Footer>>(footerList, HttpStatus.OK);
    }
    @PostMapping
    public Footer addFooterContent(@RequestBody Footer footer) {
        return service.addFooterContent(footer);
    }
    @PutMapping("/{id}")
    public Footer updateFooterContent(@RequestBody Footer footer, @PathVariable Long id) throws PortfolioNotFound {
        return service.updateFooterContent(footer, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFooterContent (@PathVariable Long id) throws PortfolioNotFound {
        service.deleteFooterContent(id);
        return new ResponseEntity<>("The content has been deleted", HttpStatus.OK);
    }
}
