package cn.edu.nju.movietubeserver.service.impl;

import cn.edu.nju.movietubeserver.dao.UserDao;
import cn.edu.nju.movietubeserver.service.AdminService;
import cn.edu.nju.movietubeserver.support.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author leolu
 * @create 2020-02-14-9:39
 **/
@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    UserDao userDao;

    @Override
    public int updateRoleIdByUsername(Integer roleId, String username) {
        try {
            return userDao.updateRoleIdByUsername(roleId,username);
        }catch (Throwable e) {
            throw new ServiceException("fail to updateRoleIdByUsername", e);
        }
    }

    @Override
    public boolean updateRoleIdByUserId(Integer userId) {
        try {
            return userDao.updateRoleIdByUserId(userId);
        }catch (Throwable e) {
            throw new ServiceException("fail to updateRoleId", e);
        }

    }
}
