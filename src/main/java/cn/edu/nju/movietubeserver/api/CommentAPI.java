package cn.edu.nju.movietubeserver.api;

import cn.edu.nju.movietubeserver.model.dto.CommentDto;
import cn.edu.nju.movietubeserver.model.dto.PostCommentDto;
import cn.edu.nju.movietubeserver.model.dto.ReceiveCommentDto;
import cn.edu.nju.movietubeserver.model.dto.ReplyCommentDto;
import cn.edu.nju.movietubeserver.model.dto.RootCommentDto;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import org.springframework.data.domain.Page;

/**
 * @author leolu
 * @create 2019-12-25-20:17
 **/
public interface CommentAPI
{

    // 获取电影的主评论列表
    RestApiResponse<Page<RootCommentDto>> listRootCommentByMovieId(Integer pageNo, Integer pageSize, Long movieId);

    // 根据电影及父评论，查找子评论回复
    RestApiResponse<Page<ReplyCommentDto>> listReplyCommentOfRootComment(Integer pageNo, Integer pageSize, Long movieId,
        String rootCommentId);

    // 获取用户发出的评论
    RestApiResponse<Page<PostCommentDto>> listUserPostComments(Integer pageNo, Integer pageSize, Integer userId);

    // 获取用户收到的评论
    RestApiResponse<Page<ReceiveCommentDto>> listUserReceiveComments(Integer pageNo, Integer pageSize, Integer userId);

    RestApiResponse<Void> insertComment(CommentDto commentDto);

    RestApiResponse<Void> deleteByCommentId(Long commentId);

    RestApiResponse<Void> deleteByMovieId(Long movieId);

}
