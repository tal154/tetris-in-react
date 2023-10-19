package learn.tetris.data;

import learn.tetris.models.About;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AboutJdbcTemplateRepository implements AboutRepository{
    private final JdbcTemplate jdbcTemplate;

    public AboutJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<About> findAll() {
        final String sql = """
                            select about_id, first_name, last_name, about_description, git
                            from about;
                            """;
        return jdbcTemplate.query(sql, new AboutMapper());
    }
    @Override
    public About findById(int aboutId) {

        final String sql = """
                            select about_id, first_name, last_name, about_description, git
                            from about
                            where about_id = ?;
                            """;

        return jdbcTemplate.query(sql, new AboutMapper(), aboutId)
                .stream()
                .findFirst().orElse(null);
    }
}
