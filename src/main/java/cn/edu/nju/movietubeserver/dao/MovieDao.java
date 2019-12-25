package cn.edu.nju.movietubeserver.dao;

import cn.edu.nju.movietubeserver.dao.po.MoviePo;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dc
 * @date 2019/12/23 15:11
 */
@Repository
public interface MovieDao extends ElasticsearchRepository<MoviePo, Long>
{

    List<MoviePo> findByTitle(String title);
}
