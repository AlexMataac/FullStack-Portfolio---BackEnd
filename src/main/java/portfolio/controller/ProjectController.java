package portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.entity.Project;
import portfolio.exception.PortfolioNotFound;
import portfolio.service.AboutMeService;
import portfolio.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin("http://localhost:3000/")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjectContent(Project project) throws PortfolioNotFound {
        List<Project> projectList = service.getAllProjectContent(project);
        return new ResponseEntity<List<Project>>(projectList, HttpStatus.OK);
    }
    @PostMapping
    public Project addProjectContent(@RequestBody Project project) {
        return service.addProjectContent(project);
    }
    @PutMapping("/{id}")
    public Project updateProjectContent(@RequestBody Project project, @PathVariable Long id) throws PortfolioNotFound {
        return service.updateProjectContent(project, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProjectContent (@PathVariable Long id) throws PortfolioNotFound {
        service.deleteProjectContent(id);
        return new ResponseEntity<>("The content has been deleted", HttpStatus.OK);
    }
}
