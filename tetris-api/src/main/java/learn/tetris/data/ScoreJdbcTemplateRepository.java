package learn.tetris.data;

import learn.tetris.models.Score;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class ScoreJdbcTemplateRepository implements ScoreRepository {

    private final JdbcTemplate jdbcTemplate;
    public ScoreJdbcTemplateRepository(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}
    @Override
    public List<Score> findAll() {
        final String sql = """
                            select score_id, user_id, score
                            from score
                            order by score desc
                            limit 10;
                            """;
        return jdbcTemplate.query(sql, new ScoreMapper());
    }

    @Override
    public Score findByUserId(int scoreId) {
        final String sql = """
                           select score_id, user_id, score
                            from score
                            order by score desc
                            where user_id = ?;
                            """;
        return jdbcTemplate.query(sql, new ScoreMapper(), scoreId).stream()
                .findFirst().orElse(null);
    }

    @Override
    public Score add(Score score) {
        final String sql = """
                            insert into score (user_id, score)
                            values (?,?);
                            """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, score.getUserId());
            ps.setInt(2, score.getScore());
            return ps;
        }, keyHolder);

        if(rowAffected <= 0){
            return null;
        }

        score.setScoreId(keyHolder.getKey().intValue());
        return score;
    }

//    @Override
//    public boolean update(Score score) {
//        final String sql = """
//                            update score set
//                            title = ?,
//                            post_content = ?
//                            where forum_id = ?;
//                            """;
//        return jdbcTemplate.update(sql,
//                score.getScore(),
//                score.getScoreId()) > 0;
//    }

//    @Override
//    public boolean deleteById(int forumId) {
//        return jdbcTemplate.update("delete from score where forum_id = ?;", forumId) > 0;
//    }
}
