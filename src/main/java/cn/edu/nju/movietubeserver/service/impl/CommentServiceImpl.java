package cn.edu.nju.movietubeserver.service.impl;

import cn.edu.nju.movietubeserver.api.dto.CommentDto;
import cn.edu.nju.movietubeserver.constant.ESIndexConstant;
import cn.edu.nju.movietubeserver.dao.CommentDao;
import cn.edu.nju.movietubeserver.dao.po.CommentPo;
import cn.edu.nju.movietubeserver.service.CommentService;
import cn.edu.nju.movietubeserver.support.elasticsearch.dao.BaseElasticSearchDao;
import cn.edu.nju.movietubeserver.support.elasticsearch.service.impl.BaseElasticSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author leolu
 * @create 2019-12-26-19:36
 **/
@Service
public class CommentServiceImpl extends BaseElasticSearchServiceImpl<CommentDto, CommentPo, Long> implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Page<CommentDto> listByMovieId(Integer pageNo, Integer pageSize, Integer movieId) {
        return searchByKeyword(pageNo,pageSize, ESIndexConstant.Comment.MOVIE_ID, String.valueOf(movieId));
    }

    @Override
    public Boolean insertComment(CommentPo commentPo) {
        return commentDao.save(commentPo) != null;
    }

    @Override
    public BaseElasticSearchDao<CommentPo, Long> getBaseElasticSearchDao() {
        return commentDao;
    }

    @Override
    public CommentDto convert(CommentPo commentPo) {
        Objects.requireNonNull(commentPo,"评论不能为空");
        return commentPo.toDto();
    }
}
