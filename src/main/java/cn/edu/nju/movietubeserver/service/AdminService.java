package cn.edu.nju.movietubeserver.service;

/**
 * @author leolu
 * @create 2020-02-14-9:29
 **/
public interface AdminService {

    //根据用户名修改权限
    int updateRoleIdByUsername(Integer roleId, String username);

    //根据用户ID更换权限
    boolean updateRoleIdByUserId(Integer userId);
}
