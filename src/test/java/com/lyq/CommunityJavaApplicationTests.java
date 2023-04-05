package com.lyq;

import cn.hutool.core.util.PageUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyq.model.UserInfo;
import com.lyq.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CommunityJavaApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        Page<Object> page = Page.of(1, 10);
        IPage<UserInfo> userPage = userInfoService.getUserPage(Page.of(0, 10,true), new UserInfo());
        log.info(JSONUtil.toJsonStr(userPage));
    }

    @Test
    void test2() {
    }


}
