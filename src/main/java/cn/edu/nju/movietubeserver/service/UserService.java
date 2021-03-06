package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.model.domain.SimpleUser;
import cn.edu.nju.movietubeserver.model.dto.UserDto;
import cn.edu.nju.movietubeserver.model.po.UserPo;
import cn.edu.nju.movietubeserver.support.exception.DBException;
import cn.edu.nju.movietubeserver.support.exception.ServiceException;
import java.util.List;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author dc
 * @date 2019/12/21 22:11
 */
public interface UserService
{

    int insertUser(UserPo userPo)
        throws DBException, ServiceException;

    UserDto getUserByEmail(String email);

    UserDto getUserByUsername(String username)
        throws UsernameNotFoundException;

    int updateUserInfoById(UserPo userPo)
        throws DBException, ServiceException;

    boolean verifyPassword(String rawPassword, String encodedPassword);

    List<SimpleUser> listAllSimpleUsers();
}
