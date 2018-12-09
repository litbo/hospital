package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.litbo.hospital.supervise.bean.Person;
import com.litbo.hospital.supervise.service.TestPageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestPageServiceImpl implements TestPageService {

    @Override
    public List<Person> getStudent() {
        PageHelper.startPage(1,3);
        List<Person> result = new ArrayList<>();
        return result;
    }

}
