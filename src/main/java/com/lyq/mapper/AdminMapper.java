package com.lyq.mapper;

import com.lyq.model.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Leon
* @description 针对表【sys_admin(管理员)】的数据库操作Mapper
* @createDate 2023-04-15 15:23:10
* @Entity com.lyq.model.Admin
*/
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}




