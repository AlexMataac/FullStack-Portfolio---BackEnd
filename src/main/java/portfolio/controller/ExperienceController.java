package portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.exception.PortfolioNotFound;
import portfolio.entity.Experience;
import portfolio.service.ExperienceService;

import java.util.List;
@RestController
@RequestMapping("/experience")
@CrossOrigin("http://localhost:3000/")
public class ExperienceController {

    @Autowired
    private ExperienceService service;

    @GetMapping
    public ResponseEntity<List<Experience>> getAllExperienceContent(Experience experience) throws PortfolioNotFound {
        List<Experience> experienceList = service.getExperienceContent(experience);
        return new ResponseEntity<List<Experience>>(experienceList, HttpStatus.OK);
    }
    @PostMapping
    public Experience addExperienceContent(@RequestBody Experience experience) {
        return service.addExperienceContent(experience);
    }
    @PutMapping("/{id}")
    public Experience updateExperienceContent(@RequestBody Experience experience, @PathVariable Long id) throws PortfolioNotFound {
        return service.updateExperienceContent(experience, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExperienceContent (@PathVariable Long id) throws PortfolioNotFound {
        service.deleteExperienceContent(id);
        return new ResponseEntity<>("The content has been deleted", HttpStatus.OK);
    }
}
