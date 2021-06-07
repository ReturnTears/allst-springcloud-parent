package com.allst.springcloud.controller;

import com.allst.springcloud.service.ResumeServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author June
 * @since 2021年04月
 */
@RestController
@RequestMapping("/autodeliver")
public class AutodeliverController {

    @Autowired
    private ResumeServiceFeignClient resumeServiceFeignClient;

    @GetMapping("/checkPort/{userId}")
    public Integer findResumeOpenStateByRibbon(@PathVariable Long userId) { // userId: 1545132
        Integer resumeState = resumeServiceFeignClient.findResumeState(userId);
        System.out.println("resumeState:" + resumeState);
        return resumeState;
    }
}
