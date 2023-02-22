package portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.entity.Navbar;
import portfolio.exception.PortfolioNotFound;
import portfolio.service.NavbarService;

import java.util.List;

@RestController
@RequestMapping("/navbar")
@CrossOrigin("http://localhost:3000/")
public class NavbarController {

    @Autowired
    private NavbarService service;

    @GetMapping
    public ResponseEntity<List<Navbar>> getAllNavbarContent(Navbar navbar) throws PortfolioNotFound {
        List<Navbar> navbarList = service.getAllNavbarContent(navbar);
        return new ResponseEntity<List<Navbar>>(navbarList, HttpStatus.OK);
    }
    @PostMapping
    public Navbar addNavbarContent(@RequestBody Navbar navbar) {
        return service.addNavbarContent(navbar);
    }
    @PutMapping("/{id}")
    public Navbar updateNavbarContent(@RequestBody Navbar navbar, @PathVariable Long id) throws PortfolioNotFound {
        return service.updateNavbarContent(navbar, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNavbarContent (@PathVariable Long id) throws PortfolioNotFound {
        service.deleteNavbarContent(id);
        return new ResponseEntity<>("The content has been deleted", HttpStatus.OK);
    }
}
