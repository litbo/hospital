package com.litbo.hospital.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;



@Data
public class EqInfoVo {

    //流水号
    private String eqId;

    //设备名称id
    private String eqNid;

    //设备名称
    private String eqName;
    //拼音码
    private String eqPym;
    //设备编号
    private String eqSbbh;
    //资产编号
    private String eqZcbh;
    //品名id
    private String eqPmId;
    //品名name
    private String eqPmName;
    //设备规格
    private String eqGg;
    //设备型号
    private String eqXh;
    //资金来源id
    private String zjlyId;
    //资金来源name
    private String eqZjlyName;
    //计量单位id
    private String eqJldwId;
    //计量单位name
    private String eqJldwName;
    //单价
    private BigDecimal eqPrice;
    //台账类别
    private String eqTzlb;
    //保修开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date eqBxkssj;
    //保修结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date eqBxjssj;
    //保修响应时间
    private Integer eqBxxysj;
    //维修商id
    private String sbcsIdWxs;
    //维修商id
    private String wxsName;
    //部门id
    private String eqBmid;
    //部门名称
    private String eqBmName;
    //管理归口
    private String eqGlgk;
    //查询分类id  (设备分类)
    private String eqCxflId;
    //查询分类name
    private String eqCxflName;
    //启用时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date eqQysj;
    //注册证编号
    private String eqZczbh;
    //注册证名称
    private String eqZczmc;
    //设备厂商Id
    private String sbcsIdScs;

    private String scsName;
    //品牌
    private String eqPp;
    //生产编号
    private String eqScbh;
    //配置
    private String eqPz;
    //使用年限
    private Integer eqSynx;
    //供应商id
    private String sbcsIdGys;

    private String gysName;
    //合同编号
    private String eqHtbh;
    //采购日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date eqCgrq;
    //使用部门负责人
    private String eqSybmfzr;
    //安装日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date eqAzrq;
    //安装位置
    private String eqAzwz;
    //设备值班类型
    private String eqZblx;
    //折旧率
    private BigDecimal eqZjl;
    //建档人
    private String userId;
    //建档人
    private String userName;
    //建档日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date eqJdrq;
    //卷宗编号
    private String eqJzbh;
    //档案编号
    private String eqDabh;
    //院区
    private String eqYq;
    //设备照片
    private String[] sbzp;
    private String eqSbzp;
    //铭牌照片
    private String[] mpzp;
    private String eqMpzp;
    //安装环境要求
    private String eqAzhjyq;


    //取得方式id
    private Integer qdfsId;
    //购置类别id
    private Integer gzlbId;
    //设备是否用水
    private String eqUsewater;
    //单次用水量
    private Integer eqDcysl;
    //额定功率
    private Integer eqEdgl;
    //使用状态
    private String eqSyzt;
    //备注
    private String eqBz;
    //使用范围
    private String eqSyfw;

    //生产日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date eqScrq;
    //折旧年限
    private Integer eqZjnx;


}