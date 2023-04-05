package com.lyq.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyq.model.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Qualifier;

/**
* @author Leon
* @description 针对表【sys_user_info(用户表)】的数据库操作Mapper
* @createDate 2023-01-01 13:46:04
* @Entity generator.model.UserInfo
*/
@Qualifier("userInfoMapper")
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    IPage<UserInfo> getUserPage(IPage<UserInfo> page, UserInfo userInfo);
}




