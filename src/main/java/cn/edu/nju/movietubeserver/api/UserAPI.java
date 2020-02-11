package cn.edu.nju.movietubeserver.api;

import cn.edu.nju.movietubeserver.model.dto.LoginUserDto;
import cn.edu.nju.movietubeserver.model.dto.RegisterUserDto;
import cn.edu.nju.movietubeserver.model.dto.UserDto;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.security.Principal;
import org.springframework.validation.BindingResult;

/**
 * @author dc
 * @date 2019/12/21 21:23
 */
@Api(value = "用户模块的相关接口", description = "用户模块的相关接口")
public interface UserAPI
{

    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    RestApiResponse<String> login(@ApiParam(value = "用户登录信息实体", required = true) LoginUserDto loginUserDto,
        final BindingResult bindingResult);

    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    RestApiResponse<Integer> register(@ApiParam(value = "用户注册信息实体", required = true) RegisterUserDto registerUserDto,
        final BindingResult bindingResult);

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息", httpMethod = "GET")
    RestApiResponse<UserDto> getUserInfo(Principal user);

    @ApiOperation(value = "更新用户邮箱", notes = "更新用户邮箱", httpMethod = "POST")
    RestApiResponse<String> updateUserEmailById(@ApiParam(value = "用户ID", required = true) Integer userId,
        @ApiParam(value = "用户新邮箱", required = true) String newEmail);

    @ApiOperation(value = "更新用户名", notes = "更新用户名", httpMethod = "POST")
    RestApiResponse<String> updateUsernameById(@ApiParam(value = "用户ID", required = true) Integer userId,
        @ApiParam(value = "用户新用户名", required = true) String newUsername);

    @ApiOperation(value = "退出登录", notes = "退出登录", httpMethod = "GET")
    RestApiResponse<Void> logout(Principal user);
}
