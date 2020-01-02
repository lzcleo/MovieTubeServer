package cn.edu.nju.movietubeserver.service.impl;

import cn.edu.nju.movietubeserver.dao.PermissionDao;
import cn.edu.nju.movietubeserver.dao.UserDao;
import cn.edu.nju.movietubeserver.model.domain.SimpleUser;
import cn.edu.nju.movietubeserver.model.dto.UserDto;
import cn.edu.nju.movietubeserver.model.po.UserPo;
import cn.edu.nju.movietubeserver.service.UserService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
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
        // 超级管理员拥有所有权限
        return Optional.ofNullable(userDao.getUserByEmail(email))
            .map(userPo -> setAdminPermission(userPo,
                user -> StringUtils.equalsIgnoreCase("ROLE_ADMIN", user.getRoleName()),
                user -> user.setPermissionCodeList(permissionDao.getAllAuthorityCode())))
            .map(UserPo::toDto)
            .orElseThrow(() -> new UsernameNotFoundException("email not found"));
    }

    @Override
    public UserDto getUserByUsername(String username)
        throws UsernameNotFoundException
    {
        // 超级管理员拥有所有权限
        return Optional.ofNullable(userDao.getUserByUsername(username))
            .map(userPo -> setAdminPermission(userPo,
                user -> StringUtils.equalsIgnoreCase("ROLE_ADMIN", user.getRoleName()),
                user -> user.setPermissionCodeList(permissionDao.getAllAuthorityCode())))
            .map(UserPo::toDto)
            .orElseThrow(() -> new UsernameNotFoundException("username not found"));
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

    /**
     * 查询所有用户的简单信息
     * @return
     */
    @Override
    public List<SimpleUser> listAllSimpleUsers()
    {
        return userDao.listAllSimpleUsers();
    }

    private UserPo setAdminPermission(UserPo userPo, Predicate<UserPo> predicate, Consumer<UserPo> consumer)
    {
        Objects.requireNonNull(userPo, "用户不能为空");
        Objects.requireNonNull(predicate, "判断用户是否是管理员的条件不能为空");
        Objects.requireNonNull(consumer, "对管理员赋予权限的操作不能为空");
        if (predicate.test(userPo))
        {
            consumer.accept(userPo);
        }
        return userPo;
    }
}
