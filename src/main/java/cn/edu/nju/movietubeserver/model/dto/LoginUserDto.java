package cn.edu.nju.movietubeserver.model.dto;

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

    private String username;

    private String email;

    @NotBlank(message = "密码不能为空")
    private String password;

}
