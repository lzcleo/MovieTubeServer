package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.model.dto.MovieDto;
import cn.edu.nju.movietubeserver.model.po.MoviePo;
import cn.edu.nju.movietubeserver.support.elasticsearch.service.BaseElasticSearchService;
import java.util.Optional;
import org.springframework.data.domain.Page;

/**
 * @author dc
 * @date 2020/2/7 0:34
 */
public interface MovieService extends BaseElasticSearchService<MovieDto, MoviePo, Long>
{

    Page<MovieDto> searchByKeyword(Integer pageNo, Integer pageSize, String searchKeyword, String... fieldNames);

    Optional<MovieDto> getByMovieIdFromAllIndices(Long movieId);

}
