package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.service.SgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 申购单表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgInfoController {
    @Autowired
    SgInfoService sgInfoService;


}
