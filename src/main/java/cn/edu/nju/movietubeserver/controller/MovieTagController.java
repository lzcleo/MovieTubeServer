package cn.edu.nju.movietubeserver.controller;

import cn.edu.nju.movietubeserver.api.MovieTagAPI;
import cn.edu.nju.movietubeserver.constant.ESIndexFieldKey.Movie;
import cn.edu.nju.movietubeserver.model.domain.MovieTagIndexBean;
import cn.edu.nju.movietubeserver.model.dto.MovieTagDto;
import cn.edu.nju.movietubeserver.service.MovieTagService;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import cn.edu.nju.movietubeserver.support.response.RestApiResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dc
 * @date 2020/2/7 0:03
 */
@RestController
@RequestMapping(path = "/api/movieTag")
public class MovieTagController implements MovieTagAPI
{

    @Autowired
    private MovieTagService movieTagService;

    @Autowired
    private MovieTagIndexBean movieTagIndexBean;

    @Override
    @RequestMapping(path = "/getCountOfMoviesByTag", method = RequestMethod.GET)
    public RestApiResponse<Long> getCountOfMoviesByTag(@RequestParam String tag)
    {
        //TODO 对tag进行校验
        movieTagIndexBean.setIndexName(tag);
        return RestApiResponseUtil.createSuccessResponse(movieTagService.getCount());
    }

    @Override
    @RequestMapping(path = "/listByTag", method = RequestMethod.GET)
    public RestApiResponse<Page<MovieTagDto>> listByTag(@RequestParam String tag,
        @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "20") Integer pageSize)
    {
        //TODO 对tag进行校验
        movieTagIndexBean.setIndexName(tag);
        return RestApiResponseUtil.createSuccessResponse(movieTagService.listByPage(pageNo, pageSize));
    }

    @Override
    @RequestMapping(path = "/getByMovieId", method = RequestMethod.GET)
    public RestApiResponse<MovieTagDto> getByMovieId(@RequestParam String tag, @RequestParam Long movieId)
    {
        //TODO 对tag进行校验
        movieTagIndexBean.setIndexName(tag);
        return movieTagService.getByPrimaryKey(movieId)
            .map(RestApiResponseUtil::createSuccessResponse)
            .orElse(RestApiResponseUtil.createErrorResponse(String.format("movie not found, id [%s]", movieId)));
    }

    @Override
    @RequestMapping(path = "/searchByKeyword", method = RequestMethod.GET)
    public RestApiResponse<Page<MovieTagDto>> searchByKeyword(@RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "20") Integer pageSize, @RequestParam String keyword)
    {
        return RestApiResponseUtil.createSuccessResponse(movieTagService.searchByKeyword(pageNo,
            pageSize,
            keyword,
            Movie.TITLE,
            Movie.DIRECTORS,
            Movie.CASTS));
    }
}
