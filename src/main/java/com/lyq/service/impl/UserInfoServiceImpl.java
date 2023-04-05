package com.lyq.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyq.mapper.UserInfoMapper;
import com.lyq.model.UserInfo;
import com.lyq.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Leon
 * @description 针对表【sys_user_info(用户表)】的数据库操作Service实现
 * @createDate 2023-01-01 13:46:04
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public IPage<UserInfo> getUserPage(IPage<UserInfo> page, UserInfo userInfo) {
        IPage<UserInfo> userPage = userInfoMapper.getUserPage(page, userInfo);
        return userPage;
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Override
    public UserInfo getUserByUsername(String username) {
        return getOne(Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUsername,username).last("LIMIT 1"));
    }
}




