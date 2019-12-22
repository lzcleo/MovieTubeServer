package cn.edu.nju.movietubeserver.dao.po;

import cn.edu.nju.movietubeserver.api.dto.UserDto;
import cn.edu.nju.movietubeserver.utils.ObjectUtil;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2019/12/21 22:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPo
{

    private Integer userId;

    @NotEmpty(message = "用户名不能为空")
    @Size(min = 3, message = "用户名长度不能少于3位")
    private String username;

    @NotEmpty(message = "邮箱不能为空")
    @Email
    private String email;

    @NotEmpty(message = "性别不能为空")
    private String gender;

    /**
     * 如果开启以下JSONField注解，在po to dto 的转换时password属性会丢失，不方便controller层用dto的password来判断密码是否匹配
     * 因此暂时去掉了
     */
    //    @JSONField(serialize = false)
    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, message = "密码长度不能少于6位")
    private String password;

    private Integer roleId;

    //来自联表查询
    private String roleName;

    // 用户的角色对应的权限code
    private List<String> permissionCodeList;

    public static UserPo valueOf(UserDto userDto)
    {
        return ObjectUtil.deepCloneByJson(userDto, UserPo.class);
    }

    public UserDto toDto()
    {
        return ObjectUtil.deepCloneByJson(this, UserDto.class);
    }
}
