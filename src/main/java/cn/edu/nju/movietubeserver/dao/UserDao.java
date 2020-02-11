package cn.edu.nju.movietubeserver.dao;

import cn.edu.nju.movietubeserver.model.domain.SimpleUser;
import cn.edu.nju.movietubeserver.model.po.UserPo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

/**
 * @author dc
 * @date 2019/12/22 13:38
 */
@Mapper
@Repository
public interface UserDao
{

    int insertUser(@Param("userPo") UserPo userPo)
        throws DuplicateKeyException;

    UserPo getUserByUsername(@Param("username") String username);

    UserPo getUserByEmail(@Param("email") String email);

    int updateUserEmailById(@Param("userId") Integer userId, @Param("newEmail") String newEmail)
        throws DuplicateKeyException;

    int updateUsernameById(@Param("userId") Integer userId, @Param("newUsername") String newUsername)
        throws DuplicateKeyException;

    List<SimpleUser> listAllSimpleUsers();
}
