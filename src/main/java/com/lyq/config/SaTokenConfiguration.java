package com.lyq.config;

import cn.dev33.satoken.config.SaTokenConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaTokenConfiguration {

    private static final String TOKEN_NAME = "sa-token";
    private static final Integer TIMEOUT = 2592000;
    private static final Integer ACTIVITY_TIMEOUT = -1;
    private static final String TOKEN_STYLE = "uuid";

    @Bean
    public SaTokenConfig saTokenConfig(){
        SaTokenConfig saTokenConfig = new SaTokenConfig();
        // token名称 (同时也是cookie名称)
        saTokenConfig.setTokenName(TOKEN_NAME);
        // token有效期，单位s 默认30天, -1代表永不过期
        saTokenConfig.setTimeout(TIMEOUT);
        // token临时有效期 (指定时间内无操作就视为token过期) 单位: 秒
        saTokenConfig.setActivityTimeout(ACTIVITY_TIMEOUT);
        // 是否允许同一账号并发登录 (为true时允许一起登录, 为false时新登录挤掉旧登录)
        // 在多人登录同一账号时，是否共用一个token (为true时所有登录共用一个token, 为false时每次登录新建一个token)
        saTokenConfig.setIsShare(true);
        // token风格
        saTokenConfig.setTokenStyle(TOKEN_STYLE);
        return saTokenConfig;
    }
}
