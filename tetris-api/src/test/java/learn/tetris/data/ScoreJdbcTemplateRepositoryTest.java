package learn.tetris.data;

import learn.tetris.models.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ScoreJdbcTemplateRepositoryTest {

    private final int MISSING_ID = 99;
    private final int NEXT_ID = 3;

    @Autowired
    ScoreJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setUp(){ knownGoodState.set(); }

    @Test
    void shouldFindAll(){
        List<Score> scoreList = repository.findAll();
        assertNotNull(scoreList);
        assertEquals(2, scoreList.size());
    }

    @Test
    void shouldFindById(){
        Score actual = repository.findByUserId(1);
        assertNotNull(actual);
        assertEquals(100, actual.getScore());
    }

    @Test
    void shouldNotFindByMissingId(){
        Score actual = repository.findByUserId(MISSING_ID);
        assertNull(actual);
    }

    @Test
    void shouldAdd(){
        Score arg = makeScore();
        Score actual = repository.add(arg);
        assertNotNull(actual);
        assertEquals(NEXT_ID, actual.getScoreId());
    }

    @Test
    void shouldUpdate(){
        Score score = makeScore();
        score.setScoreId(1);
        assertTrue(repository.update(score));
        score.setScoreId(MISSING_ID);
        assertFalse(repository.update(score));
    }

    @Test
    void shouldDelete(){
        assertTrue(repository.deleteById(2));
        assertFalse(repository.deleteById(MISSING_ID));
    }

    Score makeScore(){
        Score score = new Score();
        score.setUserId(1);
        score.setScore(100);

        return score;
    }

}