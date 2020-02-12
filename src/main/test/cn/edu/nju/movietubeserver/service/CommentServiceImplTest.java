package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.MovieTubeServerMain;
import cn.edu.nju.movietubeserver.dao.CommentDao;
import cn.edu.nju.movietubeserver.model.domain.SimpleUser;
import cn.edu.nju.movietubeserver.model.po.CommentPo;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author zhaodeyu
 * @classname CommentServiceImplTest
 * @description TODO
 * @date 2020-02-12 16:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTubeServerMain.class)
@Transactional
public class CommentServiceImplTest {
    @Autowired
    CommentService commentService;

    @Test
    public void getBaseElasticSearchDao() {
        assertNotNull(commentService.getBaseElasticSearchDao());
    }

    @Test
    public void listRootCommentByMovieId() {
        int pageNo = 0;
        int pageSize = 10;
        long movieId = 3114117;
        Map<Integer, SimpleUser> simpleUserMap = new HashMap<>();
        assertNotNull(commentService.listRootCommentByMovieId(pageNo, pageSize, movieId, simpleUserMap));
    }

    @Test
    public void listReplyCommentOfRootComment() {
        int pageNo = 0;
        int pageSize = 10;
        long movieId = 3114117;
        String rootCommentId = "-1";
        Map<Integer, SimpleUser> simpleUserMap = new HashMap<>();
        assertNotNull(commentService.listReplyCommentOfRootComment(pageNo, pageSize, movieId, rootCommentId, simpleUserMap));
    }

    @Test
    public void listUserPostComments() {
        int pageNo = 0;
        int pageSize = 10;
        int userId = 1;
        Map<Integer, SimpleUser> simpleUserMap = new HashMap<>();
        assertNotNull(commentService.listUserPostComments(pageNo, pageSize, userId, simpleUserMap));
    }

    @Test
    public void listUserReceiveComments() {
        int pageNo = 0;
        int pageSize = 10;
        int userId = 1;
        Map<Integer, SimpleUser> simpleUserMap = new HashMap<>();
        assertNotNull(commentService.listUserReceiveComments(pageNo, pageSize, userId, simpleUserMap));
    }

    @Test
    public void insertComment() {
//        CommentPo commentPo = new CommentPo();
//        commentPo.setParentCommentId("-1");
//        commentPo.setRootCommentId("-1");
//        commentPo.setMovieId((long) 3114117);
//        commentPo.setFromUserId(1);
//        commentPo.setToUserId(-1);
//        commentPo.setContent("单元测试");
//        commentPo.setCreateTime(LocalDateTime.now().toString());
//        try {
//            commentService.insertComment(commentPo);
//            assertTrue(true);
//        } catch (Exception e) {
//            fail();
//        }
    }

    @Test
    public void deleteByCommentId() {
    }

    @Test
    public void deleteByMovieId() {
    }

    @Test
    public void convert() {
    }
}