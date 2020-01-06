package cn.edu.nju.movietubeserver.model.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2020/1/3 10:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto
{

    @ApiModelProperty(value = "用户名，如果使用用户名登录，则email为空字符串")
    private String username;

    @ApiModelProperty(value = "用户邮箱，如果使用邮箱登录，则username为空字符串")
    private String email;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "用户登录密码")
    private String password;

}
