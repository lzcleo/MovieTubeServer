package cn.edu.nju.movietubeserver.dao;

import cn.edu.nju.movietubeserver.model.po.CommentPo;
import cn.edu.nju.movietubeserver.support.elasticsearch.dao.BaseElasticSearchDao;
import org.springframework.stereotype.Repository;

/**
 * @author leolu
 * @create 2019-12-25-20:08
 **/
@Repository
public interface CommentDao extends BaseElasticSearchDao<CommentPo, String>
{

}
