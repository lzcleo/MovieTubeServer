package cn.edu.nju.movietubeserver.dao;

import cn.edu.nju.movietubeserver.dao.po.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author dc
 * @date 2019/12/22 13:38
 */
@Mapper
@Repository
public interface UserDao
{

    UserPo getUserByUsername(@Param("username") String username);

    UserPo getUserByEmail(@Param("email") String email);
}
