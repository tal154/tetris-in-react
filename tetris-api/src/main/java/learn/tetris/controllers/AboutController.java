package learn.tetris.controllers;

import learn.tetris.domain.AboutService;
import learn.tetris.models.About;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/about")
public class AboutController {
    private final AboutService service;

    public AboutController(AboutService service) {
        this.service = service;
    }

    // CRUD implementation
    // R - GET request
    @GetMapping
    public List<About> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public About findById(@PathVariable int id) {
        return service.findById(id);
    }
}