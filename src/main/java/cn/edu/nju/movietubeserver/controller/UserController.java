package cn.edu.nju.movietubeserver.controller;

import cn.edu.nju.movietubeserver.api.UserAPI;
import cn.edu.nju.movietubeserver.model.dto.UserDto;
import cn.edu.nju.movietubeserver.service.UserService;
import cn.edu.nju.movietubeserver.support.jwt.JWTUtil;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import cn.edu.nju.movietubeserver.support.response.RestApiResponseUtil;
import java.security.Principal;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dc
 * @date 2019/12/21 21:26
 */
@RestController
@RequestMapping(path = "/api/user")
public class UserController implements UserAPI
{

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * 可以以用户名登录或邮箱登录
     *
     * @param userDto
     * @return
     */
    @Override
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public RestApiResponse<String> login(@RequestBody UserDto userDto)
    {
        if (StringUtils.isEmpty(userDto.getUsername()) && StringUtils.isEmpty(userDto.getEmail()))
        {
            return RestApiResponseUtil.createErrorResponse("用户名或邮箱不能为空");
        }
        if (StringUtils.isEmpty(userDto.getPassword()))
        {
            return RestApiResponseUtil.createErrorResponse("密码不能为空");
        }

        UserDto dbUser = null;
        // 用户名登录
        if (StringUtils.isNotEmpty(userDto.getUsername()))
        {
            dbUser = userService.getUserByUsername(userDto.getUsername());
            if (dbUser == null)
            {
                return RestApiResponseUtil.createErrorResponse("用户" + userDto.getUsername() + "不存在");
            }
        }

        if (StringUtils.isNotEmpty(userDto.getEmail()))
        {
            dbUser = userService.getUserByEmail(userDto.getEmail());
            if (dbUser == null)
            {
                return RestApiResponseUtil.createErrorResponse("用户" + userDto.getEmail() + "不存在");
            }
            userDto.setUsername(dbUser.getUsername());
        }

        if (!userService.verifyPassword(userDto.getPassword(), dbUser.getPassword()))
        {
            return RestApiResponseUtil.createErrorResponse("密码错误");
        }

        return RestApiResponseUtil.createSuccessResponse(createToken(userDto.getUsername()));
    }

    @Override
    @RequestMapping(path = "/getUserInfo", method = RequestMethod.GET)
    public RestApiResponse<UserDto> getUserInfo(final Principal user)
    {
        UserDto userDB = userService.getUserByUsername(user.getName());
        return RestApiResponseUtil.createSuccessResponse(userDB);
    }

    @Override
    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public RestApiResponse<Void> logout(final Principal user)
    {
        // TODO 让token失效
        // 可以在前端清除token
        return RestApiResponseUtil.createSuccessResponse();
    }

    private String createToken(final String username)
    {
        Objects.requireNonNull(username, "username cannot be null");
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtUtil.sign(username, userDetails.getAuthorities());
    }
}
