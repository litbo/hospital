package com.litbo.hospital.supervise.service;

import com.litbo.hospital.supervise.bean.PbJhVO;
import org.springframework.stereotype.Service;

@Service
public interface PbService {

    public void addPbPlan(PbJhVO pbJhVO);
}
