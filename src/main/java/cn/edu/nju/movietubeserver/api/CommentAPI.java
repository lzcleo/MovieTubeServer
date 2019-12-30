package cn.edu.nju.movietubeserver.api;

import cn.edu.nju.movietubeserver.api.dto.CommentDto;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import org.springframework.data.domain.Page;

/**
 * @author leolu
 * @create 2019-12-25-20:17
 **/
public interface CommentAPI {

    RestApiResponse<Page<CommentDto>> listByMovieId(Integer pageNo, Integer pageSize, Integer movieId);

    RestApiResponse<Page<CommentDto>> listByPage(Integer pageNo, Integer pageSize);

    RestApiResponse<Boolean> insertComment(CommentDto commentDto);

}
