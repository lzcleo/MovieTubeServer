package cn.edu.nju.movietubeserver.api;

import cn.edu.nju.movietubeserver.model.dto.UserDto;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import java.security.Principal;

/**
 * @author dc
 * @date 2019/12/21 21:23
 */
public interface UserAPI
{
    RestApiResponse<String> login(UserDto userDto);

    RestApiResponse<UserDto> getUserInfo(Principal user);

    RestApiResponse<Void> logout(Principal user);
}
