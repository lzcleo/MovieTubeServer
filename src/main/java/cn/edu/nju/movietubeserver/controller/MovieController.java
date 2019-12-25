package cn.edu.nju.movietubeserver.controller;

import cn.edu.nju.movietubeserver.api.MovieAPI;
import cn.edu.nju.movietubeserver.api.dto.MovieDto;
import cn.edu.nju.movietubeserver.service.MovieService;
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
 * @date 2019/12/24 9:57
 */
@RestController
@RequestMapping(path = "/api/movie")
public class MovieController implements MovieAPI
{

    @Autowired
    private MovieService movieService;

    @Override
    @RequestMapping(path = "/getCountOfMovies", method = RequestMethod.GET)
    public RestApiResponse<Long> getCountOfMovies()
    {
        return RestApiResponseUtil.createSuccessResponse(movieService.getCount());
    }

    @Override
    @RequestMapping(path = "/getByMovieId", method = RequestMethod.GET)
    public RestApiResponse<MovieDto> getByMovieId(@RequestParam Long movieId)
    {
        return movieService.getByPrimaryKey(movieId)
            .map(RestApiResponseUtil::createSuccessResponse)
            .orElse(RestApiResponseUtil.createErrorResponse(String.format("movie not found, id [%s]", movieId)));
    }

    @Override
    @RequestMapping(path = "/listByDirectorName", method = RequestMethod.GET)
    public RestApiResponse<Page<MovieDto>> listByDirectorName(@RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "30") Integer pageSize, @RequestParam String directorName)
    {
        return RestApiResponseUtil.createSuccessResponse(movieService.listByDirectorName(pageNo,
            pageSize,
            directorName));
    }

    @Override
    @RequestMapping(path = "/listByCastName", method = RequestMethod.GET)
    public RestApiResponse<Page<MovieDto>> listByCastName(@RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "30") Integer pageSize, @RequestParam String castName)
    {
        return RestApiResponseUtil.createSuccessResponse(movieService.listByCastName(pageNo, pageSize, castName));
    }

    @Override
    @RequestMapping(path = "/listByPage", method = RequestMethod.GET)
    public RestApiResponse<Page<MovieDto>> listByPage(@RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "30") Integer pageSize)
    {
        return RestApiResponseUtil.createSuccessResponse(movieService.listByPage(pageNo, pageSize));
    }
}
