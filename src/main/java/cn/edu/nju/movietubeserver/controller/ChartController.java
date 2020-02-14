package cn.edu.nju.movietubeserver.controller;

import cn.edu.nju.movietubeserver.api.ChartAPI;
import cn.edu.nju.movietubeserver.model.dto.BarChartDto;
import cn.edu.nju.movietubeserver.service.ChartService;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import cn.edu.nju.movietubeserver.support.response.RestApiResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaodeyu
 * @classname ChartController
 * @description TODO
 * @date 2020-02-13 11:11
 */
@RestController
@RequestMapping(path = "/api/chart")
public class ChartController implements ChartAPI {
    @Autowired
    private ChartService chartService;


    @Override
    @GetMapping(path = "/getCommentCountBarChart")
    public RestApiResponse<BarChartDto> getCommentCountBarChart(@RequestParam(defaultValue = "0") Integer userId)
    {
        return RestApiResponseUtil.createSuccessResponse(chartService.getCommentCounts(userId));
    }
}
