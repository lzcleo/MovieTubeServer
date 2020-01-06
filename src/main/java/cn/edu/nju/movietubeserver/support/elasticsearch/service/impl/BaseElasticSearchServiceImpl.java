package cn.edu.nju.movietubeserver.support.elasticsearch.service.impl;

import cn.edu.nju.movietubeserver.support.elasticsearch.dao.BaseElasticSearchDao;
import cn.edu.nju.movietubeserver.support.elasticsearch.service.BaseElasticSearchService;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.elasticsearch.index.query.MultiMatchQueryBuilder.Type;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

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
    public Page<T> matchSearchByKeyword(String fieldName, String searchKeyword, Pageable pageable,
        SortBuilder<?> sortBuilder)
    {
        SearchQuery searchQuery =
            new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery(fieldName, searchKeyword))
                .withPageable(pageable)
                .withSort(sortBuilder)
                .build();
        return getBaseElasticSearchDao().search(searchQuery).map(this::convert);
    }

    @Override
    public Page<T> multiMatchSearchByKeyword(Pageable pageable, SortBuilder<?> sortBuilder, String searchKeyword,
        String... fieldNames)
    {
        SearchQuery searchQuery =
            new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(searchKeyword, fieldNames)
                .type(Type.BEST_FIELDS)
                .tieBreaker(0.1f)).withPageable(pageable).withSort(sortBuilder).build();
        return getBaseElasticSearchDao().search(searchQuery).map(this::convert);
    }

    @Override
    public Page<T> termSearchByKeyword(String fieldName, String searchKeyword, Pageable pageable,
        SortBuilder<?> sortBuilder)
    {
        SearchQuery searchQuery =
            new NativeSearchQueryBuilder().withQuery(QueryBuilders.termQuery(fieldName, searchKeyword))
                .withPageable(pageable)
                .withSort(sortBuilder)
                .build();
        return getBaseElasticSearchDao().search(searchQuery).map(this::convert);
    }

    @Override
    public Page<T> search(QueryBuilder queryBuilder, Pageable pageable, FieldSortBuilder fieldSortBuilder)
    {
        Objects.requireNonNull(queryBuilder, "查询条件不能为空");
        Objects.requireNonNull(pageable, "分页条件不能为空");
        Objects.requireNonNull(fieldSortBuilder, "排序条件不能为空");
        SearchQuery query = new NativeSearchQueryBuilder().withQuery(queryBuilder) // 搜索条件
            .withPageable(pageable) // 分页
            .withSort(fieldSortBuilder) // 排序
            .build();
        return getBaseElasticSearchDao().search(query).map(this::convert);
    }

    @Override
    public Page<T> search(SearchQuery searchQuery)
    {
        Objects.requireNonNull(searchQuery, "查询条件不能为空");
        return getBaseElasticSearchDao().search(searchQuery).map(this::convert);
    }

    public abstract BaseElasticSearchDao<E, U> getBaseElasticSearchDao();

    public abstract T convert(E e);

}
