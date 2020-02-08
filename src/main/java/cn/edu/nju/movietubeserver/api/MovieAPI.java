package cn.edu.nju.movietubeserver.api;

import cn.edu.nju.movietubeserver.model.dto.MovieDto;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;

/**
 * @author dc
 * @date 2019/12/24 9:57
 */
@Api(value = "电影模块的相关接口", description = "电影模块的相关接口")
public interface MovieAPI
{

    @ApiOperation(value = "获取电影数量", notes = "获取电影数量", httpMethod = "GET")
    RestApiResponse<Long> getCountOfMovies();

    @ApiOperation(value = "根据电影ID获取电影实体信息", notes = "根据电影ID获取电影实体信息，电影ID是唯一的", httpMethod = "GET")
    RestApiResponse<MovieDto> getByMovieId(@ApiParam(value = "电影ID", required = true) Long movieId);

    @ApiOperation(value = "根据关键字搜索", notes = "根据关键字搜索，关键字可以是电影名称、导演、演员姓名，返回分页结果", httpMethod = "GET")
    RestApiResponse<Page<MovieDto>> listByKeyword(@ApiParam(value = "第几页，默认0", required = false) Integer pageNo,
        @ApiParam(value = "每页多少条数据，默认20", required = false) Integer pageSize,
        @ApiParam(value = "要搜索的关键字", required = true) String keyword);

    @ApiOperation(value = "根据电影名称搜索", notes = "根据电影名称搜索，分词分析，返回分页结果", httpMethod = "GET")
    RestApiResponse<Page<MovieDto>> listByMovieName(@ApiParam(value = "第几页，默认0", required = false) Integer pageNo,
        @ApiParam(value = "每页多少条数据，默认20", required = false) Integer pageSize,
        @ApiParam(value = "要搜索的电影名称", required = true) String movieName);

    @ApiOperation(value = "根据导演姓名搜索", notes = "根据导演姓名搜索，分词分析，返回分页结果", httpMethod = "GET")
    RestApiResponse<Page<MovieDto>> listByDirectorName(@ApiParam(value = "第几页，默认0", required = false) Integer pageNo,
        @ApiParam(value = "每页多少条数据，默认20", required = false) Integer pageSize,
        @ApiParam(value = "要搜索的导演姓名", required = true) String directorName);

    @ApiOperation(value = "根据演员姓名搜索", notes = "根据演员姓名搜索，分词分析，返回分页结果", httpMethod = "GET")
    RestApiResponse<Page<MovieDto>> listByCastName(@ApiParam(value = "第几页，默认0", required = false) Integer pageNo,
        @ApiParam(value = "每页多少条数据，默认20", required = false) Integer pageSize,
        @ApiParam(value = "要搜索的演员姓名", required = true) String castName);

    @ApiOperation(value = "分页获取电影列表", notes = "分页获取电影列表，默认一页20条数据", httpMethod = "GET")
    RestApiResponse<Page<MovieDto>> listByPage(@ApiParam(value = "第几页，默认0", required = false) Integer pageNo,
        @ApiParam(value = "每页多少条数据，默认20", required = false) Integer pageSize);

}
