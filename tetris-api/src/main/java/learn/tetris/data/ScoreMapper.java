package learn.tetris.data;

import learn.tetris.models.Score;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreMapper implements RowMapper<Score> {
    @Override
    public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
        Score score = new Score();
        score.setScoreId(rs.getInt("score_id"));
        score.setUserId(rs.getInt("user_id"));
        score.setScore(rs.getInt("score"));
        score.setUsername(rs.getString("username"));

        return score;

    }
}
