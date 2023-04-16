package com.lyq.mapper;

import com.lyq.model.Follow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Leon
* @description 针对表【sys_follow(用户关注信息)】的数据库操作Mapper
* @createDate 2023-04-16 16:28:58
* @Entity com.lyq.model.Follow
*/
@Mapper
public interface FollowMapper extends BaseMapper<Follow> {

}




