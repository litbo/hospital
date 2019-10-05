package com.litbo.hospital.lifemanage.checkBeforeUse.test;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.checkBeforeUse.controller.SpecificationController;
import com.litbo.hospital.lifemanage.checkBeforeUse.dao.SpecificationDao;
import com.litbo.hospital.lifemanage.checkBeforeUse.service.SpecificationService;
import com.litbo.hospital.lifemanage.checkBeforeUse.vo.*;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqInfoVO;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    SpecificationService specificationService;

    @Autowired
    SpecificationDao specificationDao;

    @Autowired
    SpecificationController specificationController;


    @org.junit.Test
    public void t1(){
        PageInfo<UserVo> userVoPageInfo = specificationService.searchAppointUsers(1, 10, "  ");
        List<UserVo> list = userVoPageInfo.getList();
        list.forEach(System.out::println);
    }

    @org.junit.Test
    public void t2(){
    }

    @org.junit.Test
    public void t3(){
        PageInfo<EqInfoVO2> eqInfoVO2PageInfo = specificationService.searchAppointEqInfos(1, 10, "", "光疗设备", "", "CT室");
        eqInfoVO2PageInfo.getList().forEach(System.out::println);
    }

    @org.junit.Test
    public void t4() throws ParseException {
        SaveStandardVO saveStandardVO = new SaveStandardVO();
        saveStandardVO.setStandardName("kbw");
        saveStandardVO.setEquipmentNumber("65");
        saveStandardVO.setApplicableEquipment("kbw");
        saveStandardVO.setReviewerNumber("kbw");
        saveStandardVO.setCycle(1);
        String time = "1998-04-26";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        saveStandardVO.setDate(sdf.parse(time));
        saveStandardVO.setDesignerNumber("kbw");

        saveStandardVO.setList(new ArrayList<>());

        saveStandardVO.getList().add(new SaveStandardProjectVO("01","0201"));
        saveStandardVO.getList().add(new SaveStandardProjectVO("03","0302"));
        saveStandardVO.getList().add(new SaveStandardProjectVO("02","0302"));
        saveStandardVO.getList().add(new SaveStandardProjectVO("01","0101"));
        saveStandardVO.getList().add(new SaveStandardProjectVO("02","0102"));




        Integer standardId = specificationService.saveStandard(saveStandardVO);


        List<SaveStandardProjectVO> list = saveStandardVO.getList();


        list.forEach(standardProjectVO -> {

        });

        Integer s = specificationService.saveStandardProject(standardId,list);
    }


    @org.junit.Test
    public void t5(){
        List<SearchStandardVO> searchStandardVOS = specificationDao.searchAllStandards(1);
        searchStandardVOS.forEach(System.out::println);
    }


    @org.junit.Test
    public void t6(){
        PageInfo<SearchStandardVO> searchStandardVOPageInfo = specificationService.searchAllStandards(1, 10,1);
        searchStandardVOPageInfo.getList().forEach(System.out::println);
    }

    @org.junit.Test
    public void t7(){
        SearchStandardVO standardVO = specificationService.searchStandard(7);
        System.out.println(standardVO);
    }

    @org.junit.Test
    public void t8(){
        List<SearchStandardProjectVO> searchStandardProjectVOS = specificationDao.searchAllProject(7);
        searchStandardProjectVOS.forEach(System.out::println);
    }

}
