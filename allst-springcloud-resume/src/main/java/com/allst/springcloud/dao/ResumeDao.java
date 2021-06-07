package com.allst.springcloud.dao;

import com.allst.springcloud.pojo.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author June
 * @since 2021年04月
 */
public interface ResumeDao extends JpaRepository<Resume, Long> {
}
