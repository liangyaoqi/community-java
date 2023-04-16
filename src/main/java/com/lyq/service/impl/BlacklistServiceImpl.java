package com.lyq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyq.model.Blacklist;
import com.lyq.service.BlacklistService;
import com.lyq.mapper.BlacklistMapper;
import org.springframework.stereotype.Service;

/**
* @author Leon
* @description 针对表【sys_blacklist(黑名单)】的数据库操作Service实现
* @createDate 2023-04-15 17:20:59
*/
@Service
public class BlacklistServiceImpl extends ServiceImpl<BlacklistMapper, Blacklist>
    implements BlacklistService{

}




