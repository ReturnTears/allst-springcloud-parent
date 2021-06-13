package com.allst.springcloud.service;

import com.allst.springcloud.pojo.Resume;

/**
 * @author June
 * @since 2021年04月
 */
public interface ResumeService {
    Resume findDefaultResumeByUserId(Long userId);
}
