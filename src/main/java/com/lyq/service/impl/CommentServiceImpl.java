package com.lyq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyq.model.Comment;
import com.lyq.service.CommentService;
import com.lyq.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author Leon
* @description 针对表【sys_comment(评论表)】的数据库操作Service实现
* @createDate 2023-03-04 20:32:20
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




