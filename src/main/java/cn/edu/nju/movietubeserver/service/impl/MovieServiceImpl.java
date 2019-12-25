package cn.edu.nju.movietubeserver.service.impl;

import cn.edu.nju.movietubeserver.api.dto.MovieDto;
import cn.edu.nju.movietubeserver.constant.ESIndexConstant.Movie;
import cn.edu.nju.movietubeserver.dao.MovieDao;
import cn.edu.nju.movietubeserver.dao.po.MoviePo;
import cn.edu.nju.movietubeserver.service.MovieService;
import java.util.Optional;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

/**
 * @author dc
 * @date 2019/12/23 17:09
 */
@Service
public class MovieServiceImpl implements MovieService
{

    @Autowired
    private MovieDao movieDao;

    @Override
    public long getCount()
    {
        return movieDao.count();
    }

    @Override
    public Optional<MovieDto> getByPrimaryKey(Long primaryKey)
    {
        return movieDao.findById(primaryKey).map(MoviePo::toDto);
    }

    @Override
    public Page<MovieDto> listByPage(Integer pageNo, Integer pageSize)
    {
        return movieDao.findAll(PageRequest.of(pageNo, pageSize)).map(MoviePo::toDto);
    }

    @Override
    public Page<MovieDto> searchByKeyword(Integer pageNo, Integer pageSize, String propertyKeyword, String value)
    {
        SearchQuery searchQuery =
            new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery(propertyKeyword, value))
                .withPageable(PageRequest.of(pageNo, pageSize))
                .build();
        return movieDao.search(searchQuery).map(MoviePo::toDto);
    }

    @Override
    public Page<MovieDto> search(QueryBuilder queryBuilder, Pageable pageable, FieldSortBuilder fieldSortBuilder)
    {
        SearchQuery query = new NativeSearchQueryBuilder().withQuery(queryBuilder) // 搜索条件
            .withPageable(pageable) // 分页
            .withSort(fieldSortBuilder) // 排序
            .build();
        return movieDao.search(query).map(MoviePo::toDto);
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
}
