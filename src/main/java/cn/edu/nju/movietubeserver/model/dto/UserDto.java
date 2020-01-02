package cn.edu.nju.movietubeserver.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2019/12/21 21:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto
{

    private Integer userId;

    // 用户名，全局唯一
    private String username;

    // 邮箱，全局唯一
    // 使用邮箱来注册、登录
    private String email;

    // 性别
    private String gender;

    private String password;

    private Integer roleId;

    private String roleName;

    private List<String> permissionCodeList;
}
