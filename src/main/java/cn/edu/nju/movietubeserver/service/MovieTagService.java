package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.model.dto.MovieTagDto;
import cn.edu.nju.movietubeserver.model.po.MovieTagPo;
import cn.edu.nju.movietubeserver.support.elasticsearch.service.BaseElasticSearchService;
import org.springframework.data.domain.Page;

/**
 * @author dc
 * @date 2020/2/7 0:34
 */
public interface MovieTagService extends BaseElasticSearchService<MovieTagDto, MovieTagPo, Long>
{

    Page<MovieTagDto> searchByKeyword(Integer pageNo, Integer pageSize, String searchKeyword, String... fieldNames);

}
