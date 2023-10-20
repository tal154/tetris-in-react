package learn.tetris.domain;

import learn.tetris.data.ScoreRepository;
import learn.tetris.models.Score;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    private final ScoreRepository repository;
    public ScoreService(ScoreRepository repository){this.repository = repository;}

    public List<Score> findAll(){return repository.findAll();}

    public Score findByUserId(int userId){return repository.findByUserId(userId);}

    public Result<Score> add(Score score){
        Result<Score> result = validate(score);
        if(!result.isSuccess()){
            return result;
        }

        if(score.getScoreId() != 0){
            result.addMessage("scoreId cannot be set for `add` operation", ResultType.INVALID);
            return result;
        }

        score = repository.add(score);
        result.setPayload(score);
        return result;
    }

//    public Result<Score> update(Score score){
//        Result<Score> result = validate(score);
//        if(!result.isSuccess()){
//            return result;
//        }
//
//        if(score.getScoreId() <= 0){
//            result.addMessage("forumId must be set for `update` operation", ResultType.INVALID);
//            return result;
//        }
//
//        if(!repository.update(score)){
//            String msg = String.format("forumId: %s, not found", score.getScoreId());
//            result.addMessage(msg, ResultType.NOT_FOUND);
//        }
//
//        return result;
//    }
//
//    public boolean deleteById(int forumId){return repository.deleteById(forumId);}

    private Result<Score> validate(Score score){
        Result<Score> result = new Result<>();
        if(score == null){
            result.addMessage("from cannot be null", ResultType.INVALID);
            return result;
        }

        if(Validations.isNullOrBlank(score.getUserId())){
            result.addMessage("forumName(username) is required.", ResultType.INVALID);
        }

        if(Validations.isNullOrBlank(score.getScore())){
            result.addMessage("title is required.", ResultType.INVALID);
        }

        /**
         * TODO: Validation conditions
         * - only need null check?
         * - using spring boot validation.
         * - string character length validation?
         */

        return result;
    }
}
