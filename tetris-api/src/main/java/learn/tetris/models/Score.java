package learn.tetris.models;

import java.time.LocalDate;
import java.util.Objects;

public class Score {
    private int scoreId;
    private int userId;
    private int score;
    private String username;
    private String postContent;
    private LocalDate postDate;

    public Score(){}

    public Score(int scoreId, int userId, int score, String username) {
        this.scoreId = scoreId;
        this.userId = userId;
        this.score = score;
        this.username = username;
    }

    public int getScoreId() {
        return scoreId;
    }
    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return scoreId == score.scoreId && Objects.equals(userId, score.userId) && Objects.equals(this.score, score.score) && Objects.equals(postContent, score.postContent) && Objects.equals(postDate, score.postDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreId, userId, score, postContent, postDate);
    }
}
