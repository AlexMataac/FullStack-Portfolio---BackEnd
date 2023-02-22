package portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.entity.ContactMe;
import portfolio.exception.PortfolioNotFound;
import portfolio.service.AboutMeService;
import portfolio.service.ContactMeService;

import java.util.List;

@RestController
@RequestMapping("/contactMe")
@CrossOrigin("http://localhost:3000/")
public class ContactMeController {

    @Autowired
    private ContactMeService service;

    @GetMapping
    public ResponseEntity<List<ContactMe>> getAllContactMeContent(ContactMe contactMe) throws PortfolioNotFound {
        List<ContactMe> contactMeList = service.getAllContactContent(contactMe);
        return new ResponseEntity<List<ContactMe>>(contactMeList, HttpStatus.OK);
    }
    @PostMapping
    public ContactMe addContactMeContent(@RequestBody ContactMe contactMe) {
        return service.addContactContent(contactMe);
    }
    @PutMapping("/{id}")
    public ContactMe updateContactMeContent(@RequestBody ContactMe contactMe, @PathVariable Long id) throws PortfolioNotFound {
        return service.updateContactContent(contactMe, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContactMeContent (@PathVariable Long id) throws PortfolioNotFound {
        service.deleteContactContent(id);
        return new ResponseEntity<>("The content has been deleted", HttpStatus.OK);
    }
}
