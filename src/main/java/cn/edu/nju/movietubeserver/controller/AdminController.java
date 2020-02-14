package cn.edu.nju.movietubeserver.controller;

import cn.edu.nju.movietubeserver.api.AdminAPI;
import cn.edu.nju.movietubeserver.service.AdminService;
import cn.edu.nju.movietubeserver.support.response.RestApiResponse;
import cn.edu.nju.movietubeserver.support.response.RestApiResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author leolu
 * @create 2020-02-13-22:54
 **/
@RestController
@RequestMapping(path = "/api/admin")
public class AdminController implements AdminAPI {

    @Autowired
    AdminService adminService;


    @Override
    @PostMapping(path = "/updateRoleIdByUsername")
    public RestApiResponse<Integer> updateRoleIdByUsername(@RequestParam Integer roleId, @RequestParam String username) {
        return RestApiResponseUtil.createSuccessResponse(adminService.updateRoleIdByUsername(roleId,username));
    }

    @Override
    @PostMapping(path = "/updateRoleIdByUserId")
    public RestApiResponse<Boolean> updateRoleIdByUserId(@RequestParam Integer userId) {
        return RestApiResponseUtil.createSuccessResponse(adminService.updateRoleIdByUserId(userId));
    }
}
