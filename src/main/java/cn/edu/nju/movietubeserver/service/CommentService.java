package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.model.domain.SimpleUser;
import cn.edu.nju.movietubeserver.model.dto.CommentDto;
import cn.edu.nju.movietubeserver.model.dto.PostCommentDto;
import cn.edu.nju.movietubeserver.model.dto.ReceiveCommentDto;
import cn.edu.nju.movietubeserver.model.dto.ReplyCommentDto;
import cn.edu.nju.movietubeserver.model.dto.RootCommentDto;
import cn.edu.nju.movietubeserver.model.po.CommentPo;
import cn.edu.nju.movietubeserver.support.elasticsearch.service.BaseElasticSearchService;
import java.util.Map;
import org.springframework.data.domain.Page;

/**
 * @author leolu
 * @create 2019-12-25-20:14
 **/
public interface CommentService extends BaseElasticSearchService<CommentDto, CommentPo, Long>
{

    // 获取电影的主评论列表
    Page<RootCommentDto> listRootCommentByMovieId(Integer pageNo, Integer pageSize, Long movieId,
        Map<Integer, SimpleUser> simpleUserMap);

    // 根据电影及主评论，查找子评论回复
    Page<ReplyCommentDto> listReplyCommentOfRootComment(Integer pageNo, Integer pageSize, Long movieId,
        String rootCommentId, Map<Integer, SimpleUser> simpleUserMap);

    // 查找用户发出的评论
    Page<PostCommentDto> listUserPostComments(Integer pageNo, Integer pageSize, Integer userId,
        Map<Integer, SimpleUser> simpleUserMap);

    // 查找用户收到的评论
    Page<ReceiveCommentDto> listUserReceiveComments(Integer pageNo, Integer pageSize, Integer userId,
        Map<Integer, SimpleUser> simpleUserMap);

    // 插入评论
    void insertComment(CommentPo commentPo);

    // 删除某条评论
    void deleteByCommentId(Long commentId);

    // 删除电影下的所有评论
    void deleteByMovieId(Long movieId);
}
