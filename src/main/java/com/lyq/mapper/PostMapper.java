package com.lyq.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyq.model.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Leon
 * @description 针对表【sys_post(帖子表)】的数据库操作Mapper
 * @createDate 2023-03-05 17:19:28
 * @Entity com.lyq.model.Post
 */
@Repository
public interface PostMapper extends BaseMapper<Post> {
    IPage<Post> listPostPage(IPage<Post> page);

    Post getPostById(@Param("postId") int postId);
}




