package cn.edu.nju.movietubeserver.dao;

import cn.edu.nju.movietubeserver.dao.po.CommentPo;
import cn.edu.nju.movietubeserver.support.elasticsearch.dao.BaseElasticSearchDao;


/**
 * @author leolu
 * @create 2019-12-25-20:08
 **/
public interface CommentDao extends BaseElasticSearchDao<CommentPo, Long> {

}
