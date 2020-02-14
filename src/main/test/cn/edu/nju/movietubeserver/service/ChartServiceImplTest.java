package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.MovieTubeServerMain;
import cn.edu.nju.movietubeserver.constant.ESIndexFieldKey;
import cn.edu.nju.movietubeserver.model.dto.PostCommentDto;
import cn.edu.nju.movietubeserver.service.impl.ChartServiceImpl;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author zhaodeyu
 * @classname ChartServiceImplTest
 * @description TODO
 * @date 2020-02-14 09:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTubeServerMain.class)
@Transactional
public class ChartServiceImplTest {
    @Autowired
    private ChartServiceImpl chartService;

    @Test
    public void getBaseElasticSearchDao() {
    }

    @Test
    public void convert() {
    }

    @Test
    public void getUserCommentCounts() {

    }

    @Test
    public void getTotalUserComment() {
    }
}