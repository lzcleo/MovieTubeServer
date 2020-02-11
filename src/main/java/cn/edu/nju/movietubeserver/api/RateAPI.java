package cn.edu.nju.movietubeserver.api;

import cn.edu.nju.movietubeserver.model.dto.RateDetailDto;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import io.swagger.annotations.Api;

/**
 * @author dc
 * @date 2020/2/11 21:32
 */
@Api(value = "打分模块的相关接口", description = "打分模块的相关接口")
public interface RateAPI
{

    RestApiResponse<Integer> insertRate(RateDetailDto rateDetailDto);

    RestApiResponse<Integer> updateRateById(RateDetailDto rateDetailDto);

}
