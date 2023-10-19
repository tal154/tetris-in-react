package learn.tetris.controllers;

import learn.tetris.domain.ScoreService;
import learn.tetris.domain.Result;
import learn.tetris.models.Score;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    private final ScoreService service;

    public ScoreController(ScoreService service){this.service = service;}

    @GetMapping
    public List<Score> findAll(){
        return service.findAll();
    }

    @GetMapping("/{forumId}")
    public Score findById(@PathVariable int forumId){return service.findById(forumId);}

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Score score){
        Result<Score> result = service.add(score);
        if(result.isSuccess()){
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @PutMapping("/{forumId}")
    public ResponseEntity<Object> update(@PathVariable int forumId, @RequestBody Score score){
        if(forumId != score.getScoreId()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Result<Score> result = service.update(score);
        if(result.isSuccess()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ErrorResponse.build(result);
    }

    @DeleteMapping("/{forumId}")
    public ResponseEntity<Void> deleteById(@PathVariable int forumId){
        if(service.deleteById(forumId)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
