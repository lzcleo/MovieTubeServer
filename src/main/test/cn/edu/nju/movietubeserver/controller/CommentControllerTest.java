package cn.edu.nju.movietubeserver.controller;

import cn.edu.nju.movietubeserver.MovieTubeServerMain;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @author zhaodeyu
 * @classname CommentControllerTest
 * @description TODO
 * @date 2020-02-12 17:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTubeServerMain.class)
@Transactional
public class CommentControllerTest {
    @Autowired
    private CommentController commentController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
    }

    @Test
    public void listRootCommentByMovieId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/comment/listRootCommentByMovieId")
                .accept(MediaType.APPLICATION_JSON).param("movieId", "3541415"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void listReplyCommentOfRootComment() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/comment/listReplyCommentOfRootComment")
                .accept(MediaType.APPLICATION_JSON).param("movieId", "3541415").param("rootCommentId", "-1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void listUserPostComments() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/comment/listUserPostComments")
                .accept(MediaType.APPLICATION_JSON).param("userId", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void listUserReceiveComments() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/comment/listUserReceiveComments")
                .accept(MediaType.APPLICATION_JSON).param("userId", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void insertComment() {
    }

    @Test
    public void deleteByCommentId() {
    }

    @Test
    public void deleteByMovieId() {
    }
}