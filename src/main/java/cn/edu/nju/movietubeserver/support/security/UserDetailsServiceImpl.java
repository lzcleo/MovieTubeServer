package cn.edu.nju.movietubeserver.support.security;

import cn.edu.nju.movietubeserver.api.dto.UserDto;
import cn.edu.nju.movietubeserver.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author dc
 * @date 2019/12/21 22:10
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException
    {
        final UserDto userDto = userService.getUserByUsername(username);
        // 权限
        final List<SimpleGrantedAuthority> authorities =
            userDto.getPermissionCodeList().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        // 角色
        authorities.add(new SimpleGrantedAuthority(userDto.getRoleName()));
        return new org.springframework.security.core.userdetails.User(userDto.getUsername(),
            userDto.getPassword(),
            authorities);
    }
}
