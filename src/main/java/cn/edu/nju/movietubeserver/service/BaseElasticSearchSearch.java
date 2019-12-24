package cn.edu.nju.movietubeserver.service;

import java.util.Optional;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author dc
 * @date 2019/12/23 21:59
 */
public interface BaseElasticSearchSearch<T, U>
{

    long getCount();

    Optional<T> getByPrimaryKey(U primaryKey);

    Page<T> listByPage(Integer pageNo, Integer pageSize);

    Page<T> searchByKeyword(Integer pageNo, Integer pageSize, String propertyKeyword, String value);

    Page<T> search(QueryBuilder queryBuilder, Pageable pageable, FieldSortBuilder fieldSortBuilder);
}
