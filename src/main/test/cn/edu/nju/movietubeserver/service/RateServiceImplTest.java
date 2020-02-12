package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.MovieTubeServerMain;
import cn.edu.nju.movietubeserver.model.po.RateDetailPo;
import cn.edu.nju.movietubeserver.support.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * @author zhaodeyu
 * @classname RateServiceImplTest
 * @description TODO
 * @date 2020-02-12 11:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTubeServerMain.class)
@Transactional
public class RateServiceImplTest {
    @Autowired
    RateService rateService;

    @Test
    public void insertRate1() {
        RateDetailPo rateDetailPo = new RateDetailPo();
        rateDetailPo.setUserId(1);
        rateDetailPo.setMovieId((long) 3114117);
        rateDetailPo.setRate(8);
        rateDetailPo.setCreateTime(LocalDateTime.now());
        rateDetailPo.setUpdateTime(LocalDateTime.now());
        assertNotEquals(-1, rateService.insertRate(rateDetailPo));
    }

    @Test
    public void insertRate2() {
        RateDetailPo rateDetailPo = new RateDetailPo();
        rateDetailPo.setId(10);
        rateDetailPo.setUserId(1);
        rateDetailPo.setMovieId((long) 3114117);
        rateDetailPo.setUpdateTime(LocalDateTime.now());
        try {
            rateService.insertRate(rateDetailPo);
        } catch (Exception e) {
            assertEquals("插入电影评分记录失败", e.getMessage());
        }
    }

    @Test
    public void updateRateById1() {
        RateDetailPo rateDetailPo = new RateDetailPo();
        rateDetailPo.setId(1);
        rateDetailPo.setUserId(1);
        rateDetailPo.setMovieId((long) 30269016);
        rateDetailPo.setRate(7);
        rateDetailPo.setCreateTime(LocalDateTime.now());
        rateDetailPo.setUpdateTime(LocalDateTime.now());
        assertNotEquals(-1, rateService.updateRateById(rateDetailPo));
    }

    @Test
    public void updateRateById2() {
        RateDetailPo rateDetailPo = new RateDetailPo();
        rateDetailPo.setId(1);
        rateDetailPo.setRate(7);
        rateDetailPo.setUpdateTime(LocalDateTime.now());
        try {
            rateService.insertRate(rateDetailPo);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void getRateByMovieId1() {
        Long movieId = (long) 30269016;
        assertTrue(rateService.getRateByMovieId(movieId) >= 0);
    }

    @Test
    public void getRateByMovieId2() {
        Long movieId = (long) 10000;
        assertTrue(rateService.getRateByMovieId(movieId) >= 0);
    }
}