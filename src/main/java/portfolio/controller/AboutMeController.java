package portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.exception.PortfolioNotFound;
import portfolio.entity.AboutMe;
import portfolio.service.AboutMeService;

import java.util.List;

@RestController
@RequestMapping("/aboutMe")
@CrossOrigin("http://localhost:3000/")
public class AboutMeController {

    @Autowired
    private AboutMeService service;

    @GetMapping
    public ResponseEntity<List<AboutMe>> getAllAboutMeContent(AboutMe aboutMe) throws PortfolioNotFound {
        List<AboutMe> aboutMeList = service.getAllAboutMeContent(aboutMe);
        return new ResponseEntity<List<AboutMe>>(aboutMeList, HttpStatus.OK);
    }
    @PostMapping
    public AboutMe addAboutMeContent(@RequestBody AboutMe aboutMe) {
        return service.addAboutMeContent(aboutMe);
    }
    @PutMapping("/{id}")
    public AboutMe updateAboutMeContent(@RequestBody AboutMe aboutMe, @PathVariable Long id) throws PortfolioNotFound {
        return service.updateAboutMeContent(aboutMe, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAboutMeContent (@PathVariable Long id) throws PortfolioNotFound {
        service.deleteAboutMeContent(id);
        return new ResponseEntity<>("The content has been deleted", HttpStatus.OK);
    }
}
