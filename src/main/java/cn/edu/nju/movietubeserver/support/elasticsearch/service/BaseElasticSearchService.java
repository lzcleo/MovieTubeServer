package cn.edu.nju.movietubeserver.support.elasticsearch.service;

import cn.edu.nju.movietubeserver.support.elasticsearch.dao.BaseElasticSearchDao;
import java.io.Serializable;
import java.util.Optional;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

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

    Page<T> searchByKeyword(Integer pageNo, Integer pageSize, String propertyKeyword, String value);

    Page<T> search(QueryBuilder queryBuilder, Pageable pageable, FieldSortBuilder fieldSortBuilder);

    BaseElasticSearchDao<E, U> getBaseElasticSearchDao();

    T convert(E e);
}
