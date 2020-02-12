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
 * @classname UserControllerTest
 * @description TODO
 * @date 2020-02-12 17:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTubeServerMain.class)
@Transactional
public class UserControllerTest {
    @Autowired
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void login() {
    }

    @Test
    public void register() {
    }

    @Test
    public void getUserInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/getUserInfo")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void updateUserEmailById() {
    }

    @Test
    public void updateUsernameById() {
    }

    @Test
    public void logout() {
    }
}