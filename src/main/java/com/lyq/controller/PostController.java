package com.lyq.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyq.DTO.Result;
import com.lyq.model.Post;
import com.lyq.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/add")
    public Result<?> add(@RequestBody Post post) {
        post.setCreatedAt(new Date());
        boolean save = postService.save(post);
        if (save) {
            return Result.success("发布成功");
        }
        return Result.failed("发布时失败");
    }

    @GetMapping("test")
    public String[] test() {
        String[] strings = new String[5];
        for (int i = 0; i < 5; i++) {
            strings[i] = RandomUtil.randomString(1);
        }
        return strings;
    }

    @GetMapping()
    public Result<?> getPostByPostId(@RequestParam("postId") String postId) {
        Post post = postService.getPostById(postId);
        if (ObjectUtil.isNull(post)) {
            return Result.failed("你查询的帖子不存在");
        }
        return Result.success(post);
    }

    @GetMapping("/list")
    public List<Post> listPost(@RequestParam(value = "curPage", required = false, defaultValue = "0") long curPage,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") long pageSize) {
        Page<Post> postPage = new Page<>(curPage, pageSize,false);
        List<Post> posts = postService.pagePost(postPage);
        if (posts.size() == 0) {
            return Collections.emptyList();
        }
        return posts;
    }
}