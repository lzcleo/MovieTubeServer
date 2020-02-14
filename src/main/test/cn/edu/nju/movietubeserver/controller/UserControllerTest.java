package cn.edu.nju.movietubeserver.controller;

import cn.edu.nju.movietubeserver.MovieTubeServerMain;
import cn.edu.nju.movietubeserver.model.dto.LoginUserDto;
import cn.edu.nju.movietubeserver.model.dto.RegisterUserDto;
import cn.edu.nju.movietubeserver.model.dto.UpdateUserDto;
import com.alibaba.fastjson.JSONObject;
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
    public void login1() throws Exception {
        LoginUserDto loginUserDto = new LoginUserDto();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(loginUserDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void login2() throws Exception {
        LoginUserDto loginUserDto = new LoginUserDto();
        loginUserDto.setUsername("");
        loginUserDto.setEmail("");
        loginUserDto.setPassword("123456");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(loginUserDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void login3() throws Exception {
        LoginUserDto loginUserDto = new LoginUserDto();
        loginUserDto.setUsername("sjkfls");
        loginUserDto.setEmail("skjdfkl");
        loginUserDto.setPassword("123456");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(loginUserDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void login4() throws Exception {
        LoginUserDto loginUserDto = new LoginUserDto();
        loginUserDto.setUsername("sjkfls");
        loginUserDto.setEmail("admin@qq.com");
        loginUserDto.setPassword("123456");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(loginUserDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void login5() throws Exception {
        LoginUserDto loginUserDto = new LoginUserDto();
        loginUserDto.setUsername("sjkfls");
        loginUserDto.setEmail("admin@qq.com");
        loginUserDto.setPassword("admin");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(loginUserDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void register1() throws Exception {
        RegisterUserDto registerUserDto = new RegisterUserDto();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(registerUserDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void register2() throws Exception {
        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setUsername("test007");
        registerUserDto.setEmail("test007@qq.com");
        registerUserDto.setGender("男");
        registerUserDto.setPassword("123456");
        registerUserDto.setConfirmPassword("12345");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(registerUserDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void register3() throws Exception {
        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setUsername("test007");
        registerUserDto.setEmail("test007@qq.com");
        registerUserDto.setGender("男");
        registerUserDto.setPassword("123456");
        registerUserDto.setConfirmPassword("123456");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(registerUserDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
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
    public void updateUserInfoById1() throws Exception {
        UpdateUserDto updateUserDto = new UpdateUserDto();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/updateUserInfoById")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(updateUserDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void updateUserInfoById2() throws Exception {
        UpdateUserDto updateUserDto = new UpdateUserDto();
        updateUserDto.setUserId(1);
        updateUserDto.setUsername("admin1");
        updateUserDto.setEmail("admin1@qq.com");
        updateUserDto.setNickname("admin1");
        updateUserDto.setPhoneNumber("17777777777");
        updateUserDto.setAddress("中国江苏省南京市");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/updateUserInfoById")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(updateUserDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void logout() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/logout")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}