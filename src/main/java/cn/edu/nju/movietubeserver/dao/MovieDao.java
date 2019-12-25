package cn.edu.nju.movietubeserver.dao;

import cn.edu.nju.movietubeserver.dao.po.MoviePo;
import cn.edu.nju.movietubeserver.support.elasticsearch.dao.BaseElasticSearchDao;
import org.springframework.stereotype.Repository;

/**
 * @author dc
 * @date 2019/12/23 15:11
 */
@Repository
public interface MovieDao extends BaseElasticSearchDao<MoviePo, Long>
{

}
