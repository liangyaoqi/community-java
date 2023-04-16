package com.lyq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyq.model.Admin;
import com.lyq.service.AdminService;
import com.lyq.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
* @author Leon
* @description 针对表【sys_admin(管理员)】的数据库操作Service实现
* @createDate 2023-04-15 15:23:10
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

}




