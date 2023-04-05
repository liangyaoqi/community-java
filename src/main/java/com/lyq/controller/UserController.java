package com.lyq.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lyq.DTO.Result;
import com.lyq.DTO.UserInfoCreateInputDTO;
import com.lyq.constant.Constant;
import com.lyq.mapper.UserInfoMapper;
import com.lyq.model.UserInfo;
import com.lyq.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public SaResult login(@RequestBody Map<String, String> paramMap) {
        UserInfo userInfo = userInfoService.getUserByUsername(paramMap.get("username"));
        if (userInfo == null) {
            return SaResult.error("用户不存在，请检查用户名是否则正确");
        }
        if (!paramMap.get("password").equals(userInfo.getPassword())) {
            return SaResult.error("密码错误");
        }
        StpUtil.login(userInfo.getId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        // 设置用户信息到session中
        SaSession session = StpUtil.getSession();
        session.set(Constant.SESSION_USER_KEY, userInfo);
        return SaResult.ok().setData(tokenInfo.getTokenValue());
    }


    @PostMapping("/registry")
    public Result<?> registry(@RequestBody UserInfo userInfo) {
        UserInfo user = userInfoService.getUserByUsername(userInfo.getUsername());
        if (user != null) {
            return Result.failed("注册失败，用户已存在");
        }
        boolean save = userInfoService.save(userInfo);
        if (!save) {
            return Result.failed("注册失败");
        }
        SaSession session = StpUtil.getSession();
        session.set(Constant.SESSION_USER_KEY, userInfo);
        return Result.success("注册成功");
    }


    @GetMapping("/getUserInfo")
    @ApiOperation(value = "获取用户信息")
    public Result<UserInfo> getUserInfo() {
        SaSession session = StpUtil.getSession();
        UserInfo userInfo = session.getModel(Constant.SESSION_USER_KEY, UserInfo.class);
        return Result.success(userInfo);
    }

    @GetMapping("/getUserById")
    public Result<UserInfo> getUserById(@RequestParam(value = "id") String id) {
        UserInfo one = userInfoService.getOne(new LambdaQueryWrapper<>(new UserInfo()).eq(UserInfo::getId, id));
        return Result.success(one);
    }
}
