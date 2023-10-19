package learn.tetris.data;

import learn.tetris.models.About;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AboutMapper implements RowMapper<About> {
    @Override
    public About mapRow(ResultSet resultSet, int i) throws SQLException {
        About about = new About();
        about.setAboutId(resultSet.getInt("about_id"));
        about.setFirstName(resultSet.getString("first_name"));
        about.setLastName(resultSet.getString("last_name"));
        about.setAboutDescription(resultSet.getString("about_description"));
        about.setGit(resultSet.getString("git"));
        return about;
    }
}
