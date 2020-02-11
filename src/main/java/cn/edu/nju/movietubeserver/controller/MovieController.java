package cn.edu.nju.movietubeserver.controller;

import cn.edu.nju.movietubeserver.api.MovieAPI;
import cn.edu.nju.movietubeserver.constant.ESIndexFieldKey.Movie;
import cn.edu.nju.movietubeserver.model.dto.MovieDto;
import cn.edu.nju.movietubeserver.service.MovieService;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import cn.edu.nju.movietubeserver.support.response.RestApiResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping(path = "/getCountOfMovies")
    public RestApiResponse<Long> getCountOfMovies()
    {
        return RestApiResponseUtil.createSuccessResponse(movieService.getCount());
    }

    @Override
    @GetMapping(path = "/getByMovieId")
    public RestApiResponse<MovieDto> getByMovieId(@RequestParam Long movieId)
    {
        return movieService.getByPrimaryKey(movieId)
            .map(RestApiResponseUtil::createSuccessResponse)
            .orElse(RestApiResponseUtil.createErrorResponse(String.format("movie not found, id [%s]", movieId)));
    }

    @Override
    @GetMapping(path = "/listByKeyword")
    public RestApiResponse<Page<MovieDto>> listByKeyword(@RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "20") Integer pageSize, @RequestParam String keyword)
    {
        return RestApiResponseUtil.createSuccessResponse(movieService.listByKeyword(pageNo,
            pageSize,
            keyword,
            Movie.TITLE,
            Movie.DIRECTORS,
            Movie.CASTS));
    }

    @Deprecated
    @Override
    @GetMapping(path = "/listByMovieName")
    public RestApiResponse<Page<MovieDto>> listByMovieName(@RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "20") Integer pageSize, @RequestParam String movieName)
    {
        return RestApiResponseUtil.createSuccessResponse(movieService.listByMovieName(pageNo, pageSize, movieName));
    }

    @Deprecated
    @Override
    @GetMapping(path = "/listByDirectorName")
    public RestApiResponse<Page<MovieDto>> listByDirectorName(@RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "20") Integer pageSize, @RequestParam String directorName)
    {
        return RestApiResponseUtil.createSuccessResponse(movieService.listByDirectorName(pageNo,
            pageSize,
            directorName));
    }

    @Deprecated
    @Override
    @GetMapping(path = "/listByCastName")
    public RestApiResponse<Page<MovieDto>> listByCastName(@RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "20") Integer pageSize, @RequestParam String castName)
    {
        return RestApiResponseUtil.createSuccessResponse(movieService.listByCastName(pageNo, pageSize, castName));
    }

    @Override
    @GetMapping(path = "/listByPage")
    public RestApiResponse<Page<MovieDto>> listByPage(@RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "20") Integer pageSize)
    {
        return RestApiResponseUtil.createSuccessResponse(movieService.listByPage(pageNo, pageSize));
    }
}
