package com.lyq.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lyq.DTO.Result;
import com.lyq.model.Follow;
import com.lyq.service.FollowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {
    private final FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @GetMapping("/{userId}")
    public Result<List<Follow>> getFollows(@PathVariable("userId") String userId) {
        List<Follow> list = followService.list(new LambdaQueryWrapper<Follow>().eq(Follow::getUserId, userId));
        return Result.success(list);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Follow follow) {
        boolean b = followService.save(follow);
        if (b) {
            return Result.success("添加成功");
        } else {
            return Result.failed("添加失败");
        }
    }

    @GetMapping("/delete/{userId}")
    public Result delete(@PathVariable("userId") String userId) {
        boolean b = followService.remove(new LambdaQueryWrapper<Follow>().eq(Follow::getUserId, userId));
        if (b) {
            return Result.success("删除成功");
        } else {
            return Result.failed("删除失败");
        }
    }

    @GetMapping("/list")
    public Result list() {
        List<Follow> list = followService.list();
        return Result.success(list);
    }

}
