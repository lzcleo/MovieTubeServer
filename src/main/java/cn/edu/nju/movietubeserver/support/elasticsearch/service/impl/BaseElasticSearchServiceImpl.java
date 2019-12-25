package cn.edu.nju.movietubeserver.support.elasticsearch.service.impl;

import cn.edu.nju.movietubeserver.support.elasticsearch.dao.BaseElasticSearchDao;
import cn.edu.nju.movietubeserver.support.elasticsearch.service.BaseElasticSearchService;
import java.io.Serializable;
import java.util.Optional;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author dc
 * @date 2019/12/25 17:07
 *
 * T: dto
 * E: po
 * U: primary key
 *
 */
public abstract class BaseElasticSearchServiceImpl<T, E, U extends Serializable>
    implements BaseElasticSearchService<T, E, U>
{
    @Override
    public long getCount()
    {
        return getBaseElasticSearchDao().count();
    }

    @Override
    public Optional<T> getByPrimaryKey(U primaryKey)
    {
        return getBaseElasticSearchDao().findById(primaryKey).map(this::convert);
    }

    @Override
    public Page<T> listByPage(Integer pageNo, Integer pageSize)
    {
        return getBaseElasticSearchDao().findAll(PageRequest.of(pageNo, pageSize)).map(this::convert);
    }

    @Override
    public Page<T> searchByKeyword(Integer pageNo, Integer pageSize, String propertyKeyword, String value)
    {
        SearchQuery searchQuery =
            new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery(propertyKeyword, value))
                .withPageable(PageRequest.of(pageNo, pageSize))
                .build();
        return getBaseElasticSearchDao().search(searchQuery).map(this::convert);
    }

    @Override
    public Page<T> search(QueryBuilder queryBuilder, Pageable pageable, FieldSortBuilder fieldSortBuilder)
    {
        SearchQuery query = new NativeSearchQueryBuilder().withQuery(queryBuilder) // 搜索条件
            .withPageable(pageable) // 分页
            .withSort(fieldSortBuilder) // 排序
            .build();
        return getBaseElasticSearchDao().search(query).map(this::convert);
    }

    public abstract BaseElasticSearchDao<E, U> getBaseElasticSearchDao();

    public abstract T convert(E e);

}
