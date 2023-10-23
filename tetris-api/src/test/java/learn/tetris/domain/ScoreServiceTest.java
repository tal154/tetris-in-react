package learn.tetris.domain;

import learn.tetris.data.ScoreRepository;
import learn.tetris.models.Score;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ScoreServiceTest {

    @Autowired
    ScoreService service;

    @MockBean
    ScoreRepository repository;

    @Test
    void shouldAdd(){
        Score score = makeScore();
        Score mockOut = makeScore();
        mockOut.setScoreId(1);

        when(repository.add(score)).thenReturn(mockOut);

        Result<Score> actual = service.add(score);
        assertEquals(ResultType.SUCCESS, actual.getType());
        assertEquals(mockOut, actual.getPayload());
    }

    @Test
    void shouldNotAddZero(){
        Score score = makeScore();
        score.setUserId(0);
        Result<Score> result = service.add(score);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotNullUser(){
        Score score =  new Score();
        score.setScore(100);
        Result<Score> result = service.add(score);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldAddNullScore() {
        Score score =  new Score();
        score.setUserId(10);
        Result<Score> result = service.add(score);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldUpdate(){
        Score score = makeScore();
        score.setScoreId(1);

        when(repository.update(score)).thenReturn(true);

        Result<Score> actual = service.update(score);
        assertEquals(ResultType.SUCCESS, actual.getType());

    }

    @Test
    void shouldNotUpdateZeroOrBlankUserId(){
        Score score = new Score();
        score.setScoreId(1);
        Result<Score> result = service.update(score);
        assertEquals(ResultType.INVALID, result.getType());

        score.setUserId(0);
        result = service.update(score);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateZeroOrBlankScore(){
        Score score = new Score();
        score.setScoreId(1);
        score.setUserId(1);

        Result<Score> result = service.update(score);
        assertEquals(ResultType.INVALID, result.getType());

        score.setScore(0);
        result = service.update(score);
        assertEquals(ResultType.INVALID, result.getType());
    }

    Score makeScore(){
        Score score = new Score();
        score.setUserId(1);
        score.setScore(100);

        return score;
    }

}