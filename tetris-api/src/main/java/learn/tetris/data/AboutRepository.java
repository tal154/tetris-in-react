package learn.tetris.data;

import learn.tetris.models.About;

import java.util.List;

public interface AboutRepository {
    List<About> findAll();

    About findById(int aboutId);
}
