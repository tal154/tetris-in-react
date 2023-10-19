package learn.tetris.data;

import learn.tetris.models.About;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AboutJdbcTemplateRepositoryTest {
    @Autowired
    AboutJdbcTemplateRepository repository;
    @Autowired
    KnownGoodState knownGoodState;
    @BeforeEach
    void setUp() { knownGoodState.set(); }

    @Test
    void shouldFindById() {
        About secret = new About(1, "first 1", "last 1", "I am a monster hunter fan","github.com/1");
        About topSecret = new About(2, "first 2", "last 2", "I am not a monster hunter fan","github.com/2");

        About actual = repository.findById(1);
        assertEquals(secret, actual);

        actual = repository.findById(2);
        assertEquals(topSecret, actual);

        actual = repository.findById(99);
        assertNull(actual);
    }

    @Test
    void shouldFindAll() {
        List<About> about = repository.findAll();
        assertNotNull(about);
        assertEquals(2, about.size());
    }
}