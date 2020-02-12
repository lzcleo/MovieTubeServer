package cn.edu.nju.movietubeserver.controller;

import cn.edu.nju.movietubeserver.MovieTubeServerMain;
import cn.edu.nju.movietubeserver.model.dto.RateDetailDto;
import cn.edu.nju.movietubeserver.model.po.RateDetailPo;
import com.alibaba.fastjson.JSON;
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
import springfox.documentation.spring.web.json.Json;

import static org.junit.Assert.*;

/**
 * @author zhaodeyu
 * @classname RateControllerTest
 * @description TODO
 * @date 2020-02-12 17:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTubeServerMain.class)
@Transactional
public class RateControllerTest {
    @Autowired
    private RateController rateController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(rateController).build();
    }

    @Test
    public void insertRate() throws Exception {
        RateDetailDto rateDetailDto = new RateDetailDto();
        rateDetailDto.setUserId(1);
        rateDetailDto.setMovieId((long) 3541415);
        rateDetailDto.setRate(5);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/rate/insertRate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(rateDetailDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void updateRateById() throws Exception {
        RateDetailDto rateDetailDto = new RateDetailDto();
        rateDetailDto.setUserId(1);
        rateDetailDto.setMovieId((long) 3541415);
        rateDetailDto.setRate(6);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/rate/updateRateById")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(rateDetailDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}