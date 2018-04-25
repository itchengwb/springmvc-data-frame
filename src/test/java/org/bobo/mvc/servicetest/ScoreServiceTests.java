package org.bobo.mvc.servicetest;


import org.bobo.score.po.Score;
import org.bobo.score.service.ScoreService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScoreServiceTests {
    //logger
    private final Logger LOGGER = LoggerFactory.getLogger(ScoreServiceTests.class);

    @Autowired
    private ScoreService scoreService;

    @Test
    public void getAllScore() throws Exception {
        List<Score> list =  scoreService.getAllScore();
        for(Score o:list){
            LOGGER.info( "===id={}, userId={},    score={}", o.getId(), o.getUserId() , o.getScore());
        }
    }

    @Test
    public void getScoreByid() throws Exception {
        List<Score> list =  scoreService.getScoreByid(2);
        for(Score o:list){
            LOGGER.info( "===id={}, userId={},    score={}", o.getId(), o.getUserId() , o.getScore());
        }
    }
}
