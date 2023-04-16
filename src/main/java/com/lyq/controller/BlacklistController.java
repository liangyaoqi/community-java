package com.lyq.controller;

import com.lyq.DTO.Result;
import com.lyq.model.Blacklist;
import com.lyq.service.BlacklistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blacklist")
public class BlacklistController {
    private final BlacklistService blacklistService;

    public BlacklistController(BlacklistService blacklistService) {
        this.blacklistService = blacklistService;
    }

    @GetMapping
    public List<Blacklist> list() {
        return blacklistService.list();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Blacklist blacklist) {
        boolean b = blacklistService.save(blacklist);
        if (b) {
            return Result.success("添加成功", blacklist);
        } else {
            return Result.failed("添加失败");
        }
    }
}
