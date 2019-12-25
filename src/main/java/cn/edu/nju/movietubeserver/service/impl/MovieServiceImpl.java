package cn.edu.nju.movietubeserver.service.impl;

import cn.edu.nju.movietubeserver.api.dto.MovieDto;
import cn.edu.nju.movietubeserver.constant.ESIndexConstant.Movie;
import cn.edu.nju.movietubeserver.dao.MovieDao;
import cn.edu.nju.movietubeserver.dao.po.MoviePo;
import cn.edu.nju.movietubeserver.service.MovieService;
import cn.edu.nju.movietubeserver.support.elasticsearch.dao.BaseElasticSearchDao;
import cn.edu.nju.movietubeserver.support.elasticsearch.service.impl.BaseElasticSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
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
        return searchByKeyword(pageNo, pageSize, Movie.DIRECTORS, directorName);
    }

    @Override
    public Page<MovieDto> listByCastName(Integer pageNo, Integer pageSize, String castName)
    {
        return searchByKeyword(pageNo, pageSize, Movie.CASTS, castName);
    }

    @Override
    public MovieDto convert(MoviePo moviePo)
    {
        return moviePo.toDto();
    }
}
