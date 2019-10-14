package com.javaaier.lesscode.project.system.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.javaaier.lesscode.framework.config.LesscodeConfig;
import com.javaaier.lesscode.framework.web.controller.BaseController;
import com.javaaier.lesscode.project.system.menu.domain.Menu;
import com.javaaier.lesscode.project.system.menu.service.IMenuService;
import com.javaaier.lesscode.project.system.user.domain.User;

/**
 * 首页 业务处理
 * 
 * @author javaaier
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private IMenuService menuService;

    @Autowired
    private LesscodeConfig lesscodeConfig;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        User user = getSysUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", lesscodeConfig.getCopyrightYear());
        mmap.put("demoEnabled", lesscodeConfig.isDemoEnabled());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", lesscodeConfig.getVersion());
        return "main";
    }
}
