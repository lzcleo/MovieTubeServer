package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.api.dto.CommentDto;
import cn.edu.nju.movietubeserver.dao.po.CommentPo;
import cn.edu.nju.movietubeserver.support.elasticsearch.service.BaseElasticSearchService;
import org.springframework.data.domain.Page;

/**
 * @author leolu
 * @create 2019-12-25-20:14
 **/
public interface CommentService extends BaseElasticSearchService<CommentDto, CommentPo, Long> {

    //根据电影找到评论
    Page<CommentDto> listByMovieId(Integer pageNo, Integer pageSize, Integer movieId);

    //插入评论
    Boolean insertComment(CommentPo commentPo);




}
