package com.allst.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于读取模拟配置信息
 * 注解RefreshScope用于配置信息的实时刷新
 *
 * @author June
 * @since 2021年06月
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {
    @Value("${lg.message}")
    private String lgMessage;
    @Value("${my.url}")
    private String myUrl;

    @RequestMapping("/viewConfig")
    public String viewConfig() {
        return "lgMessage:" + lgMessage + ", myUrl:" + myUrl;
    }
}
