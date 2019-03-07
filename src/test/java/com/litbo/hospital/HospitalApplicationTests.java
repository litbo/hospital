package com.litbo.hospital;

import com.litbo.hospital.security.dao.FwBaoxiuDao;
import com.litbo.hospital.security.dao.JhZdDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalApplicationTests {

    @Autowired
    private FwBaoxiuDao fwBaoxiuDao;

    @Autowired
    private JhZdDao jhZdDao;

    @Test
    public void contextLoads() {
        jhZdDao.jhzdList(null, null);
    }
}
