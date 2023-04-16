package com.lyq.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyq.model.Post;
import com.lyq.service.PostService;
import com.lyq.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Leon
* @description 针对表【sys_post(帖子表)】的数据库操作Service实现
* @createDate 2023-03-05 17:19:28
*/
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
    implements PostService{

    private PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public List<Post> pagePost(Page<Post> postPage) {

        IPage<Post> postIPage = postMapper.listPostPage(postPage);
        return postIPage.getRecords();
    }

    @Override
    public Post getPostById(int postId) {
        return postMapper.getPostById(postId);
    }
}




