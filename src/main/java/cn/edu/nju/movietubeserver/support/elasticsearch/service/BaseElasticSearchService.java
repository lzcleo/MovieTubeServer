package cn.edu.nju.movietubeserver.support.elasticsearch.service;

import cn.edu.nju.movietubeserver.support.elasticsearch.dao.BaseElasticSearchDao;
import java.io.Serializable;
import java.util.Optional;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

/**
 * @author dc
 * @date 2019/12/23 21:59
 *
 * T: dto
 * E: po
 * U: primary key
 */
public interface BaseElasticSearchService<T, E, U extends Serializable>
{

    long getCount();

    Optional<T> getByPrimaryKey(U primaryKey);

    Page<T> listByPage(Integer pageNo, Integer pageSize);

    // 进行分词分析，并且根据lucene的评分机制(TF/IDF)来进行评分
    Page<T> matchSearchByKeyword(String fieldName, String searchKeyword, Pageable pageable, SortBuilder<?> sortBuilder);

    // 多字段联合搜索
    Page<T> multiMatchSearchByKeyword(Pageable pageable, SortBuilder<?> sortBuilder, String searchKeyword, String... fieldNames);

    // 精确匹配，不进行分词分析，文档中必须包含整个搜索的词汇
    Page<T> termSearchByKeyword(String fieldName, String searchKeyword, Pageable pageable, SortBuilder<?> sortBuilder);

    Page<T> search(QueryBuilder queryBuilder, Pageable pageable, FieldSortBuilder fieldSortBuilder);

    Page<T> search(SearchQuery searchQuery);

    BaseElasticSearchDao<E, U> getBaseElasticSearchDao();

    T convert(E e);
}
