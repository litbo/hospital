package com.litbo.hospital;

import com.litbo.hospital.security.dao.FwBaoxiuDao;
import com.litbo.hospital.security.dao.FwWxfDao;
import com.litbo.hospital.security.vo.FwNameVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalApplicationTests {

    @Autowired
    private FwWxfDao fwWxfDao;

    @Autowired
    private FwBaoxiuDao fwBaoxiuDao;

    @Test
    public void test(){
        FwNameVo fwNameVO = fwBaoxiuDao.findFwNameVO("201812000001", "1615925008");
        System.out.println(fwNameVO);
    }

}
