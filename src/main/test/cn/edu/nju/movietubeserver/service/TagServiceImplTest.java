package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.MovieTubeServerMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @author zhaodeyu
 * @classname TagServiceImplTest
 * @description TODO
 * @date 2020-02-12 16:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTubeServerMain.class)
@Transactional
public class TagServiceImplTest {
    @Autowired
    TagService tagService;

    @Test
    public void getTagsMap() {
        assertNotNull(tagService.getTagsMap());
    }
}