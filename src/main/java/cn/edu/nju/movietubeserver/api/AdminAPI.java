package cn.edu.nju.movietubeserver.api;

import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author leolu
 * @create 2020-02-12-11:56
 **/
@Api(value = "管理员的相关接口", description = "管理员的相关接口")
public interface AdminAPI {

    @ApiOperation(value = "用户监管", notes = "根据用户名修改权限", httpMethod = "POST")
    RestApiResponse<Integer> updateRoleIdByUsername(@ApiParam(value = "用户权限", required = true) Integer roleId,
                                           @ApiParam(value = "用户用户名", required = true) String username);

    @ApiOperation(value = "用户监管", notes = "根据用户id修改权限", httpMethod = "POST")
    RestApiResponse<Boolean> updateRoleIdByUserId(@ApiParam(value = "用户", required = true) Integer userId);

}
