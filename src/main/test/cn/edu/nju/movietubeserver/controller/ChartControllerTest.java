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
 * @classname ChartControllerTest
 * @description TODO
 * @date 2020-02-14 16:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTubeServerMain.class)
@Transactional
public class ChartControllerTest {
    @Autowired
    private ChartController chartController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(chartController).build();
    }

    @Test
    public void getCommentCountBarChart1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/chart/getCommentCountBarChart")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getCommentCountBarChart2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/chart/getCommentCountBarChart")
                .accept(MediaType.APPLICATION_JSON).param("userId", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


}