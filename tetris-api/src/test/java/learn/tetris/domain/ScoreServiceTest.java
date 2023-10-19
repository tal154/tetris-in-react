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
        Score score = makeForum();
        Score mockOut = makeForum();
        mockOut.setScoreId(1);

        when(repository.add(score)).thenReturn(mockOut);

        Result<Score> actual = service.add(score);
        assertEquals(ResultType.SUCCESS, actual.getType());
        assertEquals(mockOut, actual.getPayload());
    }

    @Test
    void shouldNotAddNullOrBlankForumName(){
        Score score = makeForum();
        score.setUserId(null);
        Result<Score> result = service.add(score);
        assertEquals(ResultType.INVALID, result.getType());

        score.setUserId(" ");
        result = service.add(score);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddNullOrBlankTitle(){
        Score score = makeForum();
        score.setScore(null);
        Result<Score> result = service.add(score);
        assertEquals(ResultType.INVALID, result.getType());

        score.setScore(" ");
        result = service.add(score);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddNullOrBlankPostContent(){
        Score score = makeForum();
        score.setPostContent(null);
        Result<Score> result = service.add(score);
        assertEquals(ResultType.INVALID, result.getType());

        score.setPostContent(" ");
        result = service.add(score);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddNullOrBlankPostDate(){
        Score score = makeForum();
        score.setPostDate(null);
        Result<Score> result = service.add(score);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldUpdate(){
        Score score = makeForum();
        score.setScoreId(1);

        when(repository.update(score)).thenReturn(true);

        Result<Score> actual = service.update(score);
        assertEquals(ResultType.SUCCESS, actual.getType());

    }

    @Test
    void shouldNotUpdateNullOrBlankForumName(){
        Score score = makeForum();
        score.setScoreId(1);
        score.setUserId(null);
        Result<Score> result = service.update(score);
        assertEquals(ResultType.INVALID, result.getType());

        score.setUserId(" ");
        result = service.update(score);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateNullOrBlankTitle(){
        Score score = makeForum();
        score.setScoreId(1);
        score.setScore(null);
        Result<Score> result = service.update(score);
        assertEquals(ResultType.INVALID, result.getType());

        score.setScore(" ");
        result = service.update(score);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateNullOrBlankPostContent(){
        Score score = makeForum();
        score.setScoreId(1);
        score.setPostContent(null);
        Result<Score> result = service.update(score);
        assertEquals(ResultType.INVALID, result.getType());

        score.setPostContent(" ");
        result = service.update(score);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateNullPostDate(){
        Score score = makeForum();
        score.setScoreId(1);
        score.setPostDate(null);
        Result<Score> result = service.update(score);
        assertEquals(ResultType.INVALID, result.getType());
    }

    Score makeForum(){
        Score score = new Score();
        score.setUserId("name99");
        score.setScore("title99");
        score.setPostContent("post-content-99");
        score.setPostDate(LocalDate.now());

        return score;
    }

}