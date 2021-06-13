package com.allst.springcloud.controller;

import com.allst.springcloud.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author June
 * @since 2021年04月
 */
@RestController
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @GetMapping("/openState/{userId}")
    public Integer findResumeState(@PathVariable("userId") Long userId) {// 1545132
        return resumeService.findDefaultResumeByUserId(userId).getIsOpenResume();
    }

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/openPort/{userId}")
    public Integer findResumePort(@PathVariable("userId") Long userId) {// 1545132
        return port;
    }
}
