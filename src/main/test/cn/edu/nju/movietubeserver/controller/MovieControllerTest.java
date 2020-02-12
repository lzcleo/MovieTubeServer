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
 * @classname MovieControllerTest
 * @description TODO
 * @date 2020-02-12 17:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTubeServerMain.class)
@Transactional
public class MovieControllerTest {
    @Autowired
    private MovieController movieController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
    }

    @Test
    public void getCountOfMoviesByTag() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/getCountOfMoviesByTag")
                .accept(MediaType.APPLICATION_JSON).param("tag", "fiction"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void listByTag() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/listByTag")
                .accept(MediaType.APPLICATION_JSON).param("tag", "fiction"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getByMovieId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/getByMovieId")
                .accept(MediaType.APPLICATION_JSON).param("tag", "fiction").param("movieId", "3541415"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void searchByKeyword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/searchByKeyword")
                .accept(MediaType.APPLICATION_JSON).param("keyword", "爱情"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}