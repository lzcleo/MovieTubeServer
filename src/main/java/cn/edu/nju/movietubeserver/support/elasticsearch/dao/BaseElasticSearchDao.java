package cn.edu.nju.movietubeserver.support.elasticsearch.dao;

import java.io.Serializable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author dc
 * @date 2019/12/25 17:29
 *
 * 在这里可以定义我们的dao层通用的ES操作方法
 *
 * E: po
 * U: primary key
 */
@NoRepositoryBean
public interface BaseElasticSearchDao<E, U extends Serializable> extends ElasticsearchRepository<E, U>
{

}
