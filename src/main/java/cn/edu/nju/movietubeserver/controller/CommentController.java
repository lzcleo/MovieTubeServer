package cn.edu.nju.movietubeserver.controller;

import cn.edu.nju.movietubeserver.api.CommentAPI;
import cn.edu.nju.movietubeserver.model.domain.SimpleUser;
import cn.edu.nju.movietubeserver.model.dto.CommentDto;
import cn.edu.nju.movietubeserver.model.dto.PostCommentDto;
import cn.edu.nju.movietubeserver.model.dto.ReceiveCommentDto;
import cn.edu.nju.movietubeserver.model.dto.ReplyCommentDto;
import cn.edu.nju.movietubeserver.model.dto.RootCommentDto;
import cn.edu.nju.movietubeserver.model.po.CommentPo;
import cn.edu.nju.movietubeserver.service.CommentService;
import cn.edu.nju.movietubeserver.service.UserService;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import cn.edu.nju.movietubeserver.support.response.RestApiResponseUtil;
import cn.edu.nju.movietubeserver.utils.DateUtil;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leolu
 * @create 2019-12-26-20:36
 **/
@RestController
@RequestMapping(path = "/api/comment")
public class CommentController implements CommentAPI
{

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Override
    @RequestMapping(path = "/listRootCommentByMovieId", method = RequestMethod.GET)
    public RestApiResponse<Page<RootCommentDto>> listRootCommentByMovieId(
        @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "20") Integer pageSize,
        @RequestParam Long movieId)
    {
        return RestApiResponseUtil.createSuccessResponse(commentService.listRootCommentByMovieId(pageNo,
            pageSize,
            movieId,
            createSimpleUserMap()));
    }

    @Override
    @RequestMapping(path = "/listReplyCommentOfRootComment", method = RequestMethod.GET)
    public RestApiResponse<Page<ReplyCommentDto>> listReplyCommentOfRootComment(
        @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "20") Integer pageSize,
        @RequestParam Long movieId, @RequestParam String rootCommentId)
    {
        return RestApiResponseUtil.createSuccessResponse(commentService.listReplyCommentOfRootComment(pageNo,
            pageSize,
            movieId,
            rootCommentId,
            createSimpleUserMap()));
    }

    @Override
    @RequestMapping(path = "/listUserPostComments", method = RequestMethod.GET)
    public RestApiResponse<Page<PostCommentDto>> listUserPostComments(@RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "30") Integer pageSize, @RequestParam Integer userId)
    {
        return RestApiResponseUtil.createSuccessResponse(commentService.listUserPostComments(pageNo,
            pageSize,
            userId,
            createSimpleUserMap()));
    }

    @Override
    @RequestMapping(path = "/listUserReceiveComments", method = RequestMethod.GET)
    public RestApiResponse<Page<ReceiveCommentDto>> listUserReceiveComments(
        @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "30") Integer pageSize,
        @RequestParam Integer userId)
    {
        Map<Integer, SimpleUser> simpleUserMap = userService.listAllSimpleUsers()
            .stream()
            .collect(Collectors.toMap(SimpleUser::getUserId, u -> u, (oldValue, newValue) -> newValue));
        return RestApiResponseUtil.createSuccessResponse(commentService.listUserReceiveComments(pageNo,
            pageSize,
            userId,
            simpleUserMap));
    }

    @Override
    @RequestMapping(path = "/insertComment", method = RequestMethod.POST)
    public RestApiResponse<Boolean> insertComment(@RequestBody CommentDto commentDto)
    {
        commentDto.setId(StringUtils.EMPTY);
        commentDto.setCreateTime(DateUtil.getCurrentTime());
        commentService.insertComment(CommentPo.valueOf(commentDto));
        return RestApiResponseUtil.createSuccessResponse(true);
    }

    @Override
    @RequestMapping(path = "/deleteByCommentId", method = RequestMethod.GET)
    public RestApiResponse<Boolean> deleteByCommentId(@RequestParam Long commentId)
    {
        //TODO 删除该评论下所有的评论回复
        commentService.deleteByCommentId(commentId);
        return RestApiResponseUtil.createSuccessResponse(true);
    }

    @Override
    @RequestMapping(path = "/deleteByMovieId", method = RequestMethod.GET)
    public RestApiResponse<Boolean> deleteByMovieId(@RequestParam Long movieId)
    {
        commentService.deleteByMovieId(movieId);
        return RestApiResponseUtil.createSuccessResponse(true);
    }

    private Map<Integer, SimpleUser> createSimpleUserMap()
    {
        return userService.listAllSimpleUsers()
            .stream()
            .collect(Collectors.toMap(SimpleUser::getUserId, user -> user, (oldValue, newValue) -> newValue));
    }

}
