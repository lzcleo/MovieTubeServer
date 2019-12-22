package cn.edu.nju.movietubeserver.service.impl;

import cn.edu.nju.movietubeserver.api.dto.UserDto;
import cn.edu.nju.movietubeserver.dao.PermissionDao;
import cn.edu.nju.movietubeserver.dao.UserDao;
import cn.edu.nju.movietubeserver.dao.po.UserPo;
import cn.edu.nju.movietubeserver.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author dc
 * @date 2019/12/21 22:13
 */
@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserDao userDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto getUserByEmail(String email)
    {
        UserPo userPo = userDao.getUserByEmail(email);
        if (userPo == null)
        {
            throw new UsernameNotFoundException("email not found");
        }
        if (StringUtils.equalsIgnoreCase("ROLE_ADMIN", userPo.getRoleName()))
        {
            // 超级管理员拥有所有权限
            userPo.setPermissionCodeList(permissionDao.getAllAuthorityCode());
        }
        return userPo.toDto();
    }

    @Override
    public UserDto getUserByUsername(String username)
        throws UsernameNotFoundException
    {
        UserPo userPo = userDao.getUserByUsername(username);
        if (userPo == null)
        {
            throw new UsernameNotFoundException("username not found");
        }
        if (StringUtils.equalsIgnoreCase("ROLE_ADMIN", userPo.getRoleName()))
        {
            // 超级管理员拥有所有权限
            userPo.setPermissionCodeList(permissionDao.getAllAuthorityCode());
        }
        return userPo.toDto();
    }

    /**
     * 判断用户登录密码是否正确
     * @param rawPassword 用户前端界面输入的密码
     * @param encodedPassword 数据库中加密的密码
     * @return 密码是否匹配
     */
    @Override
    public boolean verifyPassword(String rawPassword, String encodedPassword)
    {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
