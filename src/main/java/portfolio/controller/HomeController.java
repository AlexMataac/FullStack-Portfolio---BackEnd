package portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.exception.PortfolioNotFound;
import portfolio.entity.Home;
import portfolio.service.HomeService;

import java.util.List;

@RestController
@RequestMapping("/home")
@CrossOrigin("http://localhost:3000/")
public class HomeController {

    @Autowired
    private HomeService service;

    @GetMapping
    public ResponseEntity<List<Home>> getAllHomeContent(Home home) throws PortfolioNotFound {
        List<Home> homeList = service.getAllHomeContent(home);
        return new ResponseEntity<List<Home>>(homeList, HttpStatus.OK);
    }
    @PostMapping
    public Home addHome(@RequestBody Home home) {
        return service.addHomeContent(home);
    }
    @PutMapping("/{id}")
    public Home updateHome(@RequestBody Home home, @PathVariable Long id) throws PortfolioNotFound {
        return service.updateHomeContent(home, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHomeContent (@PathVariable Long id) throws PortfolioNotFound {
        service.deleteHomeContent(id);
        return new ResponseEntity<>("The content has been deleted", HttpStatus.OK);
    }
}
