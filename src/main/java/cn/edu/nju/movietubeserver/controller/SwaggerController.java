package cn.edu.nju.movietubeserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author dc
 * @date 2019/12/22 16:24
 *
 * API文档页面
 */
@Controller
@ApiIgnore
public class SwaggerController
{

    @RequestMapping("/api")
    public String redirect()
    {
        return "redirect:swagger-ui.html";
    }
}
