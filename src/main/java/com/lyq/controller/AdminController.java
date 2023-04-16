package com.lyq.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lyq.constant.Constant;
import com.lyq.model.Admin;
import com.lyq.model.UserInfo;
import com.lyq.service.AdminService;
import com.lyq.service.UserInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public SaResult login(@RequestBody Admin admin) {
        Admin one = adminService.getOne(new LambdaQueryWrapper<Admin>().eq(Admin::getUsername, admin.getUsername()));
        if (one == null) {
            return SaResult.error("用户不存在，请检查用户名是否则正确");
        }
        if (!admin.getPassword().equals(one.getPassword())) {
            return SaResult.error("密码错误");
        }
        StpUtil.login(admin.getUsername());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        // 设置用户信息到session中
        SaSession session = StpUtil.getSession();
        session.set(Constant.SESSION_USER_KEY, one);
        return SaResult.ok().setData(tokenInfo.getTokenValue());
    }
}
