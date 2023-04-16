package com.lyq.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyq.model.Post;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Leon
* @description 针对表【sys_post(帖子表)】的数据库操作Service
* @createDate 2023-03-05 17:19:28
*/
public interface PostService extends IService<Post> {

    List<Post> pagePost(Page<Post> postPage);

    Post getPostById(int postId);
}
