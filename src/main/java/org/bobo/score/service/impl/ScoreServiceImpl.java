package org.bobo.score.service.impl;

import org.bobo.score.dao.ScoreMapper;
import org.bobo.score.po.Score;
import org.bobo.score.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/9/1  10:53
 * Discribe: Template
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Resource
    ScoreMapper scoreMapper;

    /**
     *查询所有用户分数
     *
     * @return
     */
    public List<Score> getAllScore(){
        List<Score> list =  scoreMapper.getAllScore();
        return list;
    }

    /**
     *获取所有用户分数 by ID
     *
     * @return
     */
    public List<Score> getScoreByid(int id){
        List<Score> list =  scoreMapper.getScoreByid(id);
        return list;
    }
}
