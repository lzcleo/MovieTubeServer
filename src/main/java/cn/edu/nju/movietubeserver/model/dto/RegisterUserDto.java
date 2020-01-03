package cn.edu.nju.movietubeserver.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2020/1/3 10:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto
{

    // 用户名 全局唯一
    @NotEmpty(message = "用户名不能为空")
    @Size(min = 3, message = "用户名长度不能少于3位")
    private String username;

    // 邮箱，全局唯一
    // 使用邮箱来注册、登录
    @NotEmpty(message = "邮箱不能为空")
    @Email
    private String email;

    // 性别
    @NotEmpty(message = "性别不能为空")
    private String gender;

    // 密码
    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, message = "密码长度不能少于6位")
    private String password;

    // 确认密码
    @NotEmpty(message = "请再次输入密码")
    @Size(min = 6, message = "确认密码长度不能少于6位")
    private String confirmPassword;

}
