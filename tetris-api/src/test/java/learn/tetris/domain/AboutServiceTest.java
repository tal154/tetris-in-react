package learn.tetris.domain;

import learn.tetris.data.AboutRepository;
import learn.tetris.models.About;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AboutServiceTest {

    @Autowired
    AboutService service;

    @MockBean
    AboutRepository repository;

    @Test
    void shouldFind() {
        About expected = makeAbout();
        when(repository.findById(100)).thenReturn(expected);
        About actual = service.findById(100);
        assertEquals(expected,actual);
    }

    About makeAbout() {
        About about = new About();
        about.setAboutId(100);
        about.setFirstName("first 1");
        about.setFirstName("last 1");
        about.setFirstName("description 1");
        about.setFirstName("github.com/1");

        return about;
    }

    <T> Result<T> makePayloadResult(T payload) {
        Result<T> result = new Result<>();
        result.setPayload(payload);
        return result;
    }
    <T> Result<T> makeNotFoundResult() {
        Result<T> result = new Result<>();
        result.setNotFound();
        return result;
    }

    <T> Result<T> makeInvalidResult(String error) {
        Result<T> result = new Result<>();
        result.addMessage(error, ResultType.INVALID);
        return result;
    }
}