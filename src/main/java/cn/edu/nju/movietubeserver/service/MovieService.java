package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.model.dto.MovieDto;
import cn.edu.nju.movietubeserver.model.po.MoviePo;
import cn.edu.nju.movietubeserver.support.elasticsearch.service.BaseElasticSearchService;
import org.springframework.data.domain.Page;

/**
 * @author dc
 * @date 2019/12/23 17:08
 */
public interface MovieService extends BaseElasticSearchService<MovieDto, MoviePo, Long>
{

    Page<MovieDto> listByKeyword(Integer pageNo, Integer pageSize, String keyword, String... fieldNames);

    Page<MovieDto> listByMovieName(Integer pageNo, Integer pageSize, String movieName);

    Page<MovieDto> listByDirectorName(Integer pageNo, Integer pageSize, String directorName);

    Page<MovieDto> listByCastName(Integer pageNo, Integer pageSize, String castName);
}
