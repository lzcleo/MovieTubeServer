package cn.edu.nju.movietubeserver.service.impl;

import cn.edu.nju.movietubeserver.constant.ESIndexConstantKey.Movie;
import cn.edu.nju.movietubeserver.dao.MovieDao;
import cn.edu.nju.movietubeserver.model.dto.MovieDto;
import cn.edu.nju.movietubeserver.model.po.MoviePo;
import cn.edu.nju.movietubeserver.service.MovieService;
import cn.edu.nju.movietubeserver.support.elasticsearch.dao.BaseElasticSearchDao;
import cn.edu.nju.movietubeserver.support.elasticsearch.service.impl.BaseElasticSearchServiceImpl;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author dc
 * @date 2019/12/23 17:09
 */
@Service
public class MovieServiceImpl extends BaseElasticSearchServiceImpl<MovieDto, MoviePo, Long> implements MovieService
{

    @Autowired
    private MovieDao movieDao;

    @Override
    public BaseElasticSearchDao<MoviePo, Long> getBaseElasticSearchDao()
    {
        return movieDao;
    }

    @Override
    public Page<MovieDto> listByDirectorName(Integer pageNo, Integer pageSize, String directorName)
    {
        return matchSearchByKeyword(Movie.DIRECTORS,
            directorName,
            PageRequest.of(pageNo, pageSize),
            SortBuilders.scoreSort().order(SortOrder.DESC));
    }

    @Override
    public Page<MovieDto> listByCastName(Integer pageNo, Integer pageSize, String castName)
    {
        return matchSearchByKeyword(Movie.CASTS,
            castName,
            PageRequest.of(pageNo, pageSize),
            SortBuilders.scoreSort().order(SortOrder.DESC));
    }

    @Override
    public MovieDto convert(MoviePo moviePo)
    {
        return moviePo.toDto();
    }
}
