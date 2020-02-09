package cn.edu.nju.movietubeserver.dao;

import cn.edu.nju.movietubeserver.model.po.MovieTagPo;
import cn.edu.nju.movietubeserver.support.elasticsearch.dao.BaseElasticSearchDao;
import org.springframework.stereotype.Repository;

/**
 * @author dc
 * @date 2020/2/7 0:31
 */
@Repository
public interface MovieTagDao extends BaseElasticSearchDao<MovieTagPo, Long>
{
}
