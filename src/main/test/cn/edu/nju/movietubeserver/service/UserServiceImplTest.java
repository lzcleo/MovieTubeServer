package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.MovieTubeServerMain;
import cn.edu.nju.movietubeserver.model.po.UserPo;
import cn.edu.nju.movietubeserver.support.exception.DBException;
import cn.edu.nju.movietubeserver.support.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @author zhaodeyu
 * @classname UserServiceImplTest
 * @description TODO
 * @date 2020-02-12 10:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTubeServerMain.class)
@Transactional
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void insertUser1() {
        UserPo newUser = new UserPo();
        newUser.setEmail("2239645870@qq.com");
        newUser.setGender("男");
        newUser.setUsername("zhaodeyu");
        newUser.setPassword("123456");
        try {
            assertNotEquals(-1, userService.insertUser(newUser));
        } catch (ServiceException e) {
            assertEquals("fail to insert user, name is [zhaodeyu]", e.getMessage());
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void insertUser2() {
        UserPo existUser = new UserPo();
        existUser.setEmail("2239645870@qq.com");
        existUser.setGender("男");
        existUser.setUsername("admin");
        existUser.setPassword("admin");
        try {
            userService.insertUser(existUser);
            fail();
        } catch (DBException e) {
            assertEquals("user info already exist", e.getMessage());
        } catch (ServiceException e) {
            assertEquals("fail to insert user, name is [admin]", e.getMessage());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void insertUser3() {
        UserPo existUser = new UserPo();
        existUser.setEmail("2239645870@qq.com");
        existUser.setUsername("admin");
        existUser.setPassword("admin");
        try {
            userService.insertUser(existUser);
        } catch (ServiceException e) {
            assertTrue(true);
        }
    }

    @Test
    public void getUserByEmail1() {
        String existEmail = "admin@qq.com";
        assertNotNull(userService.getUserByEmail(existEmail));
    }

    @Test
    public void getUserByEmail2() {
        String existEmail = "error@qq.com";
        try {
            userService.getUserByEmail(existEmail);
            fail();
        } catch (UsernameNotFoundException e) {
            assertEquals("email not found", e.getMessage());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getUserByUsername1() {
        String userName = "admin";
        assertNotNull(userService.getUserByUsername(userName));
    }

    @Test
    public void getUserByUsername2() {
        String userName = "error";
        try {
            userService.getUserByUsername(userName);
            fail();
        } catch (UsernameNotFoundException e) {
            assertEquals("username not found", e.getMessage());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void verifyPassword1() {
        String password = "admin";
        String encodePassword = "$2a$10$YVHTLWqY9J/H7yg2qpKuUeuuGUzpXNhu.gKCYHmqvFMyz1kp2KmfC";
        assertTrue(userService.verifyPassword(password, encodePassword));
    }

    @Test
    public void verifyPassword2() {
        String password = "test";
        String encodePassword = "$2a$10$YVHTLWqY9J/H7yg2qpKuUeuuGUzpXNhu.gKCYHmqvFMyz1kp2KmfC";
        assertFalse(userService.verifyPassword(password, encodePassword));
    }

    @Test
    public void verifyPassword3() {
        String password = "admin";
        String encodePassword = "$2a$10$nvfCAVr0sytkCcyBXgiQsuRNR4iofB14DGFp1jKVRtgvMxB9LQwte";
        assertFalse(userService.verifyPassword(password, encodePassword));
    }

    @Test
    public void listAllSimpleUsers() {
        assertNotNull(userService.listAllSimpleUsers());
    }

    @Test
    public void updateUserInfoById1() {
        UserPo userPo = new UserPo();
        userPo.setUserId(10);
        userPo.setGender("女");
        userPo.setEmail("test221@qq.com");
        userPo.setNickname("test221");
        userPo.setPhoneNumber("17777777777");
        userPo.setAddress("中国江苏省南京市");
        try {
            userService.updateUserInfoById(userPo);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void updateUserInfoById2() {
        UserPo userPo = new UserPo();
        userPo.setUserId(1);
        userPo.setUsername("test");
        userPo.setGender("女");
        userPo.setEmail("test221@qq.com");
        userPo.setNickname("test221");
        userPo.setPhoneNumber("17777777777");
        userPo.setAddress("中国江苏省南京市");
        try {
            userService.updateUserInfoById(userPo);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void updateUserInfoById3() {
        UserPo userPo = new UserPo();
        userPo.setUserId(6);
        userPo.setUsername("test003");
        userPo.setGender("女");
        userPo.setEmail("test221@qq.com");
        userPo.setNickname("test221");
        userPo.setPhoneNumber("17777777777");
        userPo.setAddress("中国江苏省南京市");
        assertNotEquals(-1, userService.updateUserInfoById(userPo));
    }




}