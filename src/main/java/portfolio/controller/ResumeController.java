package portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.exception.PortfolioNotFound;
import portfolio.entity.Resume;
import portfolio.service.ResumeService;

import java.util.List;

@RestController
@RequestMapping("/resume")
@CrossOrigin("http://localhost:3000/")
public class ResumeController {

    @Autowired
    private ResumeService service;

    @GetMapping
    public ResponseEntity<List<Resume>> getAllResumeContent(Resume resume) throws PortfolioNotFound {
        List<Resume> resumeList = service.getAllResumeContent(resume);
        return new ResponseEntity<List<Resume>>(resumeList, HttpStatus.OK);
    }
    @PostMapping
    public Resume addResumeContent(@RequestBody Resume resume) {
        return service.addResumeContent(resume);
    }
    @PutMapping("/{id}")
    public Resume updateResumeContent(@RequestBody Resume resume, @PathVariable Long id) throws PortfolioNotFound {
        return service.updateResumeContent(resume, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResumeContent (@PathVariable Long id) throws PortfolioNotFound {
        service.deleteResumeContent(id);
        return new ResponseEntity<>("The content has been deleted", HttpStatus.OK);
    }
}
