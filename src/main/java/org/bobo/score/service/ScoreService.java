package org.bobo.score.service;

import org.bobo.score.po.Score;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/9/1  10:52
 * Discribe: Template
 */
public interface ScoreService {
    /**
     *查询所有用户分数
     *
     * @return
     */
    List<Score> getAllScore();

    /**
     *获取所有用户分数 by ID
     *
     * @return
     */
    List<Score> getScoreByid(int id);
}
