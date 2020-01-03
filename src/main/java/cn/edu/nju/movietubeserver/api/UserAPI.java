package cn.edu.nju.movietubeserver.api;

import cn.edu.nju.movietubeserver.model.dto.LoginUserDto;
import cn.edu.nju.movietubeserver.model.dto.RegisterUserDto;
import cn.edu.nju.movietubeserver.model.dto.UserDto;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import java.security.Principal;
import org.springframework.validation.BindingResult;

/**
 * @author dc
 * @date 2019/12/21 21:23
 */
public interface UserAPI
{
    RestApiResponse<String> login(LoginUserDto loginUserDto, final BindingResult bindingResult);

    RestApiResponse<Integer> register(RegisterUserDto registerUserDto, final BindingResult bindingResult);

    RestApiResponse<UserDto> getUserInfo(Principal user);

    RestApiResponse<Void> logout(Principal user);
}
