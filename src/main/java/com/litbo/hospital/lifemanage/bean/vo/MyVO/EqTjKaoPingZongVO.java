package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EqTjKaoPingZongVO {

    /*事件名称*/
    private String sjmc;

    /*是否演练*/
    private String sfyl;


    /*调配列表*/
    List<EqTjKaoPingVO> list=new ArrayList<>();

    /*科室列表*/
    List<EqTjKaoPingKsListVO> kslist=new ArrayList<>();

}
