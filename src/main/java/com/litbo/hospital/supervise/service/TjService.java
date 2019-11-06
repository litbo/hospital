package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public interface TjService {
    PageInfo getInfo(int pageNum, int pageSize);
}
