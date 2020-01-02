package cn.edu.nju.movietubeserver.api;

import cn.edu.nju.movietubeserver.model.dto.MovieDto;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import org.springframework.data.domain.Page;

/**
 * @author dc
 * @date 2019/12/24 9:57
 */
public interface MovieAPI
{

    RestApiResponse<Long> getCountOfMovies();

    RestApiResponse<MovieDto> getByMovieId(Long movieId);

    RestApiResponse<Page<MovieDto>> listByDirectorName(Integer pageNo, Integer pageSize, String directorName);

    RestApiResponse<Page<MovieDto>> listByCastName(Integer pageNo, Integer pageSize, String castName);

    RestApiResponse<Page<MovieDto>> listByPage(Integer pageNo, Integer pageSize);
}
