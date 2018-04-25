package org.bobo.score.po;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/9/1  10:48
 * Discribe: Template
 */
public class Score {
    private int id;//int(11) NOT NULL,
    private int userId;//int(11) NOT NULL,
    private int score;//int(11) DEFAULT NULL,

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
