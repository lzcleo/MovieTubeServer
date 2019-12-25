package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.api.dto.MovieDto;
import org.springframework.data.domain.Page;

/**
 * @author dc
 * @date 2019/12/23 17:08
 */
public interface MovieService extends BaseElasticSearchSearch<MovieDto, Long>
{

    Page<MovieDto> listByDirectorName(Integer pageNo, Integer pageSize, String directorName);

    Page<MovieDto> listByCastName(Integer pageNo, Integer pageSize, String castName);
}
