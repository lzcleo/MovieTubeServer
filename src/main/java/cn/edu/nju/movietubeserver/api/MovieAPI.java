package cn.edu.nju.movietubeserver.api;

import cn.edu.nju.movietubeserver.model.dto.MovieDto;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import org.springframework.data.domain.Page;

/**
 * @author dc
 * @date 2020/2/8 15:23
 */
public interface MovieAPI
{

    RestApiResponse<Long> getCountOfMoviesByTag(String tag);

    RestApiResponse<Page<MovieDto>> listByTag(String tag, Integer pageNo, Integer pageSize);

    RestApiResponse<MovieDto> getByMovieId(String tag, Long movieId);

    RestApiResponse<Page<MovieDto>> searchByKeyword(Integer pageNo, Integer pageSize, String keyword);
}
