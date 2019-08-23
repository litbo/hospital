package com.litbo.hospital.lifemanage.bean.MyBean;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqHtZbVO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class EqHt {


    public EqHt() {

        this.htZt = "0";
    }

    /*主键*/
    private String id;

    /*合同编号*/
    private String htBianhao;

    /*签约地*/
    private String htQyd;

    /*甲方(买方)*/
    private String htJf;

    /*乙方(卖方)*/
    private String htYf;

    /*乙方名字*/
    private String htYfName;

    /*甲方地址*/
    private String htJfdz;

    /*乙方地址*/
    private String htYfdz;

    /*项目编号*/
    private String htXmbh;

    /*项目名称*/
    private String htXmmc;

    /*医学装备名称*/
    private String htZbmc;

    /*规格型号*/
    private String htGgxh;

    /*品牌*/
    private String htPinpai;

    /*原产地*/
    private String htYcd;

    /*单位*/
    private String htDanwei;

    /*数量*/
    private Integer htCount;

    /*单价*/
    private BigDecimal htDanjia;

    /*总价*/
    private BigDecimal htZongjia;

    /*成交金额*/
    private BigDecimal htCjje;

    /*备注*/
    private String htBeizhu;

    /*交付期*/
    private Integer htJfq;

    /*甲方查验发现问题乙方保证日*/
    private Integer htBzr;

    /*乙方调试日*/
    private Integer htTsr;

    /*验收合格后付款百分比*/
    private Integer htYsfk;

    /*质保金百分比*/
    private Integer htZbj;

    /*装备生产日期*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date htScrq;

    /*保修期*/
    private Integer htBxq;

    /*报修最大响应时间*/
    private Integer htBxxy;

    /*报修最大到场时间*/
    private Integer htBxdc;

    /*保修期满后单次故障最高费用*/
    private Long htZgfg;

    /*年度保修合同价不高于装备总价的百分比*/
    private Integer htZgbfb;

    /*年度最少维护保养次数*/
    private Integer htBycs;

    /*保修期满后零配件优惠价*/
    private Long htLpjyhj;

    /*甲方代表*/
    private String htJfdb;

    /*甲方电话  */
    private String htJfdh;

    /*纳税人登记号*/
    private String htNsrdjh;

    /*乙方代表*/
    private String htYfdb;

    /*乙方电话*/
    private String htYfdh;

    /*开户银行*/
    private String htKhyh;

    /*乙方账号*/
    private String htZh;

    /*甲方日期*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date htJfrq;

    /*乙方日期*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date htYfrq;

    /*合同状态*/
    private String htZt;

    /*装备汇总*/
    private String htZbhz;

    private List<EqHtZbVO> listZb=new ArrayList<>();

}