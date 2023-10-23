package learn.tetris.data;

import learn.tetris.models.Score;

import java.util.List;

public interface ScoreRepository {

    List<Score> findAll();

    Score findByUserId(int forumId);

    Score add(Score score);

    boolean update(Score score);
    boolean deleteById(int forumId);

}
