package org.bobo.score.dao;

import org.apache.ibatis.annotations.Param;
import org.bobo.score.po.Score;

import java.util.List;

/**
 *
 */
public interface ScoreMapper {


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
    List<Score> getScoreByid(@Param("id") int id);


}
