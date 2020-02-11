package cn.edu.nju.movietubeserver.api;

import cn.edu.nju.movietubeserver.model.dto.MovieTagDto;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import org.springframework.data.domain.Page;

/**
 * @author dc
 * @date 2020/2/8 15:23
 */
public interface MovieTagAPI
{

    RestApiResponse<Long> getCountOfMoviesByTag(String tag);

    RestApiResponse<Page<MovieTagDto>> listByTag(String tag, Integer pageNo, Integer pageSize);

    RestApiResponse<MovieTagDto> getByMovieId(String tag, Long movieId);

    RestApiResponse<Page<MovieTagDto>> searchByKeyword(Integer pageNo, Integer pageSize, String keyword);
}
