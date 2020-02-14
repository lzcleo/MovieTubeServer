package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.MovieTubeServerMain;
import cn.edu.nju.movietubeserver.constant.ESIndexFieldKey;
import cn.edu.nju.movietubeserver.model.po.MoviePo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * @author zhaodeyu
 * @classname MovieServiceImplTest
 * @description TODO
 * @date 2020-02-12 16:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTubeServerMain.class)
@Transactional
public class MovieServiceImplTest {
    @Autowired
    MovieService movieService;

    @Test
    public void getBaseElasticSearchDao() {
        assertNotNull(movieService.getBaseElasticSearchDao());
    }

    @Test
    public void searchByKeyword() {
        int pageNo = 0;
        int pageSize = 10;
        String searchKeyWord = "爱情";
        String fieldName = ESIndexFieldKey.Movie.TITLE;
        assertNotNull(movieService.searchByKeyword(pageNo, pageSize, searchKeyWord, fieldName));
    }

    @Test
    public void getByMovieIdFromAllIndices() {
        long movieId = 3114117;
        assertNotNull(movieService.getByMovieIdFromAllIndices(movieId));
    }

    @Test
    public void convert() {
        MoviePo moviePo = new MoviePo();
        moviePo.setId((long) 4181108);
        moviePo.setTitle("乡谣情缘");
        moviePo.setUrl("https://movie.douban.com/subject/4181108/");
        moviePo.setStar((double) 35);
        moviePo.setDoubanRate(7.0);
        moviePo.setCover("https://img3.doubanio.com/view/photo/s_ratio_poster/public/p668201335.jpg");
        moviePo.setCoverX((long) 510);
        moviePo.setCoverY((long) 755);
        moviePo.setCasts(new ArrayList<>(Arrays.asList("格温妮斯·帕特洛", "蒂姆·麦格罗")));
        moviePo.setDirectors(new ArrayList<>(Collections.singleton("莎娜·费斯特")));
        assertNotNull(movieService.convert(moviePo));
    }
}