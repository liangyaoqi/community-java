package com.lyq.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lyq.DTO.Result;
import com.lyq.model.Favorite;
import com.lyq.service.FavoriteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    private FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Favorite favorite) {
        boolean b = favoriteService.save(favorite);
        if (b) {
            return Result.success("添加成功");
        } else {
            return Result.failed("添加失败");
        }
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id) {
        boolean b = favoriteService.remove(new LambdaQueryWrapper<Favorite>().eq(Favorite::getUserId, id));
        if (b) {
            return Result.success("删除成功");
        } else {
            return Result.failed("删除失败");
        }
    }

    @GetMapping("/list/{userId}")
    public Result list(@PathVariable("userId") String userId) {
        return Result.success(favoriteService.list(new LambdaQueryWrapper<Favorite>().eq(Favorite::getUserId, userId)));
    }

    @GetMapping("/isfavorite")
    public Result isFavorite(@RequestParam("userId") String userId, @RequestParam("postId") Integer postId) {
        return Result.success(favoriteService.getOne(new LambdaQueryWrapper<Favorite>().eq(Favorite::getUserId, userId).eq(Favorite::getPostId, postId)) != null);
    }
}
