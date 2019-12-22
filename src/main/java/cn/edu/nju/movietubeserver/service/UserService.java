package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.api.dto.UserDto;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author dc
 * @date 2019/12/21 22:11
 */
public interface UserService
{

    UserDto getUserByEmail(String email);

    UserDto getUserByUsername(String username)
        throws UsernameNotFoundException;

    boolean verifyPassword(String rawPassword, String encodedPassword);
}
