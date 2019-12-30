package cn.edu.nju.movietubeserver.controller;

import cn.edu.nju.movietubeserver.api.CommentAPI;
import cn.edu.nju.movietubeserver.api.dto.CommentDto;
import cn.edu.nju.movietubeserver.dao.po.CommentPo;
import cn.edu.nju.movietubeserver.service.CommentService;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import cn.edu.nju.movietubeserver.support.response.RestApiResponseUtil;
import cn.edu.nju.movietubeserver.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author leolu
 * @create 2019-12-26-20:36
 **/
@RestController
@RequestMapping(path = "/api/comment")
public class CommentController implements CommentAPI {

    @Autowired
    private CommentService commentService;

    @Override
    @RequestMapping(path = "/listByMovieId", method = RequestMethod.GET)
    public RestApiResponse<Page<CommentDto>> listByMovieId(@RequestParam(defaultValue = "0") Integer pageNo,
                                                           @RequestParam(defaultValue = "30") Integer pageSize,
                                                           @RequestParam Integer movieId)
    {
        return RestApiResponseUtil.createSuccessResponse(commentService.listByMovieId(pageNo,pageSize,movieId));
    }

    @Override
    @RequestMapping(path = "/listByPage", method = RequestMethod.GET)
    public RestApiResponse<Page<CommentDto>> listByPage(@RequestParam(defaultValue = "0") Integer pageNo,
                                                        @RequestParam(defaultValue = "30") Integer pageSize)
    {
        return RestApiResponseUtil.createSuccessResponse(commentService.listByPage(pageNo, pageSize));
    }

    @Override
    @RequestMapping(path = "/insertComment", method = RequestMethod.POST)
    public RestApiResponse<Boolean> insertComment(@RequestBody CommentDto commentDto) {
        commentDto.setTime(DateUtil.getCurrentTime());
        return RestApiResponseUtil.createSuccessResponse(commentService.insertComment(CommentPo.valueOf(commentDto)));
    }



}
