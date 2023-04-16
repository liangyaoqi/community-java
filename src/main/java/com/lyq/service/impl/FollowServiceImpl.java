package com.lyq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyq.model.Follow;
import com.lyq.service.FollowService;
import com.lyq.mapper.FollowMapper;
import org.springframework.stereotype.Service;

/**
* @author Leon
* @description 针对表【sys_follow(用户关注信息)】的数据库操作Service实现
* @createDate 2023-04-16 16:28:58
*/
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow>
    implements FollowService{

}




