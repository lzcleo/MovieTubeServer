package cn.edu.nju.movietubeserver.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2019/12/22 16:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionPo
{

    private int permissionId;

    //权限对应的资源
    private String resource;

    // 权限对应的代码,对应代码中@hasAuthority(xx)
    private String authorityCode;

    // 权限对资源的操作
    private String operation;
}
