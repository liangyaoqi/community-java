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
    public Result<?> getPostByPostId(@RequestParam("postId") int postId) {
        Post post = postService.getPostById(postId);
        if (ObjectUtil.isNull(post)) {
            return Result.failed("你查询的帖子不存在");
        }
        return Result.success(post);
    }

    @GetMapping("/list")
    public List<Post> listPost(@RequestParam(value = "curPage", required = false, defaultValue = "0") long curPage,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") long pageSize) {
        Page<Post> postPage = new Page<>(curPage, pageSize, false);
        List<Post> posts = postService.pagePost(postPage);
        if (posts.size() == 0) {
            return Collections.emptyList();
        }
        return posts;
    }

    @GetMapping("/audit/{postId}")
    public Result<?> audit(@PathVariable("postId") int postId) {
        Post post = postService.getOne(new LambdaQueryWrapper<Post>().eq(Post::getId, postId));
        if (ObjectUtil.isNull(post)) {
            return Result.failed("你查询的帖子不存在");
        }
        post.setStatus("1");
        boolean b = postService.updateById(post);
        if (b) {
            return Result.success("审核成功");
        }
        return Result.failed("审核失败");
    }

    @GetMapping("/audit/list")
    public List<Post> auditList() {
        List<Post> posts = postService.list(new LambdaQueryWrapper<Post>().eq(Post::getStatus, "0"));
        if (posts.size() == 0) {
            return Collections.emptyList();
        }
        return posts;
    }

    @GetMapping("/search")
    public Result search(@RequestParam("keyword") String keyword) {
        List<Post> posts = postService.list(new LambdaQueryWrapper<Post>().like(Post::getTitle, keyword));
        if (posts.size() == 0) {
            return Result.failed("没有找到相关帖子");
        }
        return Result.success(posts);
    }

    @GetMapping("/top")
    public Result<List<Post>> topPost() {
        List<Post> posts = postService.list(new LambdaQueryWrapper<Post>().orderByDesc(Post::getCreatedAt).last("limit 5"));
        return Result.success(posts);
    }

}
