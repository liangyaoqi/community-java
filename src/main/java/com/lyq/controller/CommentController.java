package com.lyq.controller;

import com.lyq.DTO.Result;
import com.lyq.model.Comment;
import com.lyq.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Slf4j
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public Result<?> addComment(@RequestBody Comment comment) {
        comment.setCreatedAt(new Date());
        boolean save = commentService.save(comment);
        if (!save) {
            return Result.failed("发表失败，请稍后再试");
        }
        return Result.success(comment);
    }

}
