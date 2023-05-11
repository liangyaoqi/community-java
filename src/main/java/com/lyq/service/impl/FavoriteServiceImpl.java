package com.lyq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyq.model.Favorite;
import com.lyq.service.FavoriteService;
import com.lyq.mapper.FavoriteMapper;
import org.springframework.stereotype.Service;

/**
* @author 梁耀其
* @description 针对表【sys_favorite(点赞信息)】的数据库操作Service实现
* @createDate 2023-05-11 16:19:03
*/
@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite>
    implements FavoriteService{

}




