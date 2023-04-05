package com.lyq.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyq.model.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Leon
* @description 针对表【sys_user_info(用户表)】的数据库操作Service
* @createDate 2023-01-01 13:46:04
*/
public interface UserInfoService extends IService<UserInfo> {
    IPage<UserInfo> getUserPage(IPage<UserInfo> page, UserInfo userInfo);

    UserInfo getUserByUsername(String username);
}
